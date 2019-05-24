package dao;

import entity.Service;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceDaoImpl implements ServiceDao {
    @Override
    public boolean addService(Service service) {
        String sql = "insert into service (p_id, s_isDispose, s_isFinish, d_id, e_id, s_aTime, s_price) " +
                "values (?,?,?,?,?,?,?);";
        Object[] para = {
                service.getP_id(), service.getS_isDispose(), service.getS_isFinish(),
                service.getD_id(), service.getE_id(), service.getS_aTime(),
                service.getS_price()
        };
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public boolean deleteService(int s_id) {
        String sql = "delete from service where s_id = ?";
        Object[] para = {s_id};
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public boolean updateService(Service service) {
        String sql = "update record set p_id = ?, s_isDispose = ?, s_isFinish = ? " +
                "d_id = ?, e_id = ?, s_aTime = ? " +
                "s_price = ? " +
                "where s_id = ?";
        Object[] para = {
                service.getP_id(), service.getS_isDispose(), service.getS_isFinish(),
                service.getD_id(), service.getE_id(), service.getS_aTime(),
                service.getS_price(), service.getS_id()
        };
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public List<Service> findAllService() {
        String sql = "select * from service;";
        ResultSet resultSet = DBUtil.executeQuery(sql, null);
        List<Service> rtn = new ArrayList<>();
        Service service;
        try {
            while (resultSet.next()) {
                service = new Service(
                        resultSet.getInt("s_id"),
                        resultSet.getInt("p_id"),
                        resultSet.getString("s_isDispose"),
                        resultSet.getString("s_isFinish"),
                        resultSet.getInt("d_id"),
                        resultSet.getInt("e_id"),
                        (Date) resultSet.getObject("s_aTime"),
                        resultSet.getFloat("s_price")
                );
                rtn.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeAll();
        return rtn;
    }
}
