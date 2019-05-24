package dao;

import entity.Client;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao {
    @Override
    public boolean addClient(Client client) {
        String sql = "insert into client (cl_name, mobile, u_id, cl_age, cl_sex, cl_emil " +
                "values (?,?,?,?,?,?);";
        Object[] para = {
                client.getCl_name(), client.getMobile(), client.getU_id(),
                client.getCl_age(), client.getCl_sex(), client.getCl_emil()
        };
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public boolean deleteClient(int cl_id) {
        String sql = "delete from client where cl_id = ?";
        Object[] para = {cl_id};
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public boolean updateClient(Client client) {
        String sql = "update client set cl_name = ?, mobile = ?, u_id = ?, cl_age ?, " +
                "cl_sex = ?, cl_emil = ? where cl_id = ?";
        Object[] para = {client.getCl_name(), client.getMobile(), client.getU_id(), client.getCl_age(),
                client.getCl_sex(), client.getCl_emil(), client.getCl_id()};
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public List<Client> findAllClient() {
        String sql = "select * from client;";
        ResultSet resultSet = DBUtil.executeQuery(sql, null);
        List<Client> rtn = new ArrayList<>();
        Client client;
        try {
            while (resultSet.next()) {
                client = new Client(
                        resultSet.getInt("cl_id"),
                        resultSet.getString("cl_name"),
                        resultSet.getString("mobile"),
                        resultSet.getInt("u_id"),
                        resultSet.getInt("cl_age"),
                        resultSet.getString("cl_sex"),
                        resultSet.getString("cl_emil")
                );
                rtn.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeAll();
        return rtn;
    }
}
