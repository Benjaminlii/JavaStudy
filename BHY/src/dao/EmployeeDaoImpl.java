package dao;

import entity.Employee;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public boolean addEmployee(Employee employee) {
        String sql = "insert into employee (username, password, e_name, e_salary, s_id, d_id, e_sex, e_age, e_time) " +
                "values (?,?,?,?,?,?,?,?,?);";
        Object[] para = {
                employee.getUsername(), employee.getPassword(), employee.getE_name(),
                employee.getE_salary(), employee.getS_id(), employee.getD_id(),
                employee.getE_sex(), employee.getE_age(), employee.getE_time()
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
        String sql = "update employee set username = ?, password = ?, e_name = ? " +
                "e_salary = ?, s_id = ?, d_id = ? " +
                "e_sex = ?, e_age = ?, e_time = ? " +
                "where e_id = ?";
        Object[] para = {
                employee.getUsername(), employee.getPassword(), employee.getE_name(),
                employee.getE_salary(), employee.getS_id(), employee.getD_id(),
                employee.getE_sex(), employee.getE_age(), employee.getE_time(),
                employee.getE_id()
        };
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public List<Employee> findAllEmployee() throws SQLException {
        String sql = "select * from Employee;";
        ResultSet resultSet = DBUtil.executeQuery(sql, null);
        List<Employee> rtn = new ArrayList<>();
        Employee employee;
        while (resultSet.next()) {
            employee = new Employee(
                    resultSet.getInt("e_id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("e_name"),
                    resultSet.getInt("e_salary"),
                    resultSet.getInt("s_id"),
                    resultSet.getInt("d_id"),
                    resultSet.getString("e_sex"),
                    resultSet.getInt("e_age"),
                    (Date) resultSet.getObject("e_time")
            );
            rtn.add(employee);
        }
        DBUtil.closeAll();
        return rtn;
    }
}
