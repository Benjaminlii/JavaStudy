package dao;

import entity.Employee;
import entity.EmployeeCustom;
import util.DBUtil;
import util.PageUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public boolean addEmployee(Employee employee) {
        System.out.println(employee);
        String sql = "insert into employee (e_name, e_salary, s_id, d_id, u_id, e_sex, e_age, e_time) " +
                "values (?,?,?,?,?,?,?,?);";
        Object[] para = {
                employee.getE_name(), employee.getE_salary(), employee.getSt_id(), employee.getD_id(),
                employee.getU_id(), employee.getE_sex(), employee.getE_age(), employee.getE_time()
        };
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public boolean deleteEmployee(int e_id) {
        String sql = "delete from employee where e_id = ?";
        Object[] para = {e_id};
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        String sql = "update employee set e_name = ?, e_salary = ?, s_id = ?, " +
                "d_id = ?, u_id = ?, e_sex = ?, e_age = ?, e_time = ? " +
                "where e_id = ?";
        Object[] para = {
                employee.getE_name(), employee.getE_salary(), employee.getSt_id(), employee.getD_id(),
                employee.getU_id(), employee.getE_sex(), employee.getE_age(), employee.getE_time(),
                employee.getE_id()
        };
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public List<EmployeeCustom> findAllEmployeeInDetail() throws SQLException {
//        String sql = "select * from employeecustom;";
//        ResultSet resultSet = DBUtil.executeQuery(sql, null);
//        List<EmployeeCustom> rtn = new ArrayList<>();
//        EmployeeCustom employeeCustom;
//            while (resultSet.next()) {
//                employeeCustom = new EmployeeCustom(
//                        resultSet.getInt("e_id"),
//                        resultSet.getString("e_name"),
//                        resultSet.getInt("e_salary"),
//                        resultSet.getInt("s_id"),
//                        resultSet.getInt("d_id"),
//                        resultSet.getInt("u_id"),
//                        resultSet.getString("e_sex"),
//                        resultSet.getInt("e_age"),
//                        (Date) resultSet.getObject("e_time"),
//                        resultSet.getString("s_address"),
//                        resultSet.getString("d_value"),
//                        resultSet.getString("username")
//                        );
//                rtn.add(employeeCustom);
//            }
//        DBUtil.closeAll();
//        return rtn;
        return null;
    }

    @Override
    public List<EmployeeCustom> findEmployeeLimitInDetail(int page) throws SQLException {
//        String sql = "select * from employeecustom " +
//                "limit ?, ?;";
//        Object[] para = {PageUtil.getOffSet(page), PageUtil.getSize()};
//        ResultSet resultSet = DBUtil.executeQuery(sql, para);
//        List<EmployeeCustom> rtn = new ArrayList<>();
//        EmployeeCustom employeeCustom;
//        while (resultSet.next()) {
//            employeeCustom = new EmployeeCustom(
//                    resultSet.getInt("e_id"),
//                    resultSet.getString("e_name"),
//                    resultSet.getInt("e_salary"),
//                    resultSet.getInt("s_id"),
//                    resultSet.getInt("d_id"),
//                    resultSet.getInt("u_id"),
//                    resultSet.getString("e_sex"),
//                    resultSet.getInt("e_age"),
//                    (Date) resultSet.getObject("e_time"),
//                    resultSet.getString("s_address"),
//                    resultSet.getString("d_value"),
//                    resultSet.getString("username")
//            );
//            rtn.add(employeeCustom);
//        }
//        DBUtil.closeAll();
//        return rtn;
        return null;
    }
}
