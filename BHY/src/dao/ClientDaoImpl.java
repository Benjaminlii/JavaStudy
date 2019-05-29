package dao;

import entity.Client;
import entity.ClientCustom;
import util.DBUtil;
import util.PageUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao {
    @Override
    public boolean addClient(Client client) {
        String sql = "insert into client (cl_name, mobile, u_id, cl_age, cl_sex, cl_emil) " +
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
    public List<Client> findAllClient() throws SQLException {
        String sql = "select * from client;";
        ResultSet resultSet = DBUtil.executeQuery(sql, null);
        List<Client> rtn = new ArrayList<>();
        Client client;
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
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public List<Client> findClientLimit(int page) throws SQLException {
        String sql = "select * " +
                "from client " +
                "limit ?,?;";
        Object[] para = {PageUtil.getOffSet(page), PageUtil.getSize()};
        ResultSet resultSet = DBUtil.executeQuery(sql, para);
        List<Client> rtn = new ArrayList<>();
        Client client;
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
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public Client findClientByMobile(String mobile) throws SQLException {
        String sql = "select * from client where mobile = ?";
        Object[] para = {mobile};
        ResultSet resultSet = DBUtil.executeQuery(sql, para);
        Client client = null;
        if (resultSet.next()) {
            client = new Client(
                    resultSet.getInt("cl_id"),
                    resultSet.getString("cl_name"),
                    resultSet.getString("mobile"),
                    resultSet.getInt("u_id"),
                    resultSet.getInt("cl_age"),
                    resultSet.getString("cl_sex"),
                    resultSet.getString("cl_emil")
            );
        }
        DBUtil.closeAll();
        return client;
    }

    @Override
    public boolean isClientExist(String mobile) throws SQLException {
        return findClientByMobile(mobile) != null;
    }
}
