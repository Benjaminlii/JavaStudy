package dao;

import entity.Cargo;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CargoDaoImpl implements CargoDao {

    public boolean addCargo(Cargo cargo) {
        String sql = "insert into cargo (c_name, c_num, d_id, s_id, c_getDate, c_producedDate, c_expirationDate) " +
                "values (?,?,?,?,?,?,?);";
        Object[] para = {
                cargo.getC_name(), cargo.getC_num(), cargo.getD_id(),
                cargo.getS_id(), cargo.getC_getDate(), cargo.getC_producedDate(),
                cargo.getC_expirationDate()
        };
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    public boolean deleteCargo(int c_id) {
        String sql = "delete from cargo where c_id = ?";
        Object[] para = {c_id};
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    public boolean updateCargo(Cargo cargo) {
        String sql = "update cargo set c_name = ?, c_num = ?, d_id ?, " +
                "s_id = ?, c_getDate = ?, c_producedDate = ?, c_expirationDate = ? " +
                "where c_id = ?";
        Object[] para = {cargo.getC_name(), cargo.getC_num(), cargo.getD_id(),
                cargo.getS_id(), cargo.getC_getDate(), cargo.getC_producedDate(),
                cargo.getC_expirationDate(), cargo.getC_id()};
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    public List<Cargo> findAllCargo() {
        String sql = "select * from cargo;";
        ResultSet resultSet = DBUtil.executeQuery(sql, null);
        List<Cargo> rtn = new ArrayList<>();
        Cargo cargo;
        try {
            while (resultSet.next()) {
                cargo = new Cargo(resultSet.getInt("c_id"),
                        resultSet.getString("c_name"),
                        resultSet.getInt("c_num"),
                        resultSet.getInt("d_id"),
                        resultSet.getInt("s_id"),
                        (Date) resultSet.getObject("c_getDate"),
                        (Date) resultSet.getObject("c_producedDate"),
                        (Date) resultSet.getObject("c_expirationDate"));
                rtn.add(cargo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeAll();
        return rtn;
    }
}
