package service;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import entity.EmployeeCustom;

import java.sql.SQLException;
import java.util.List;

/**
 * 关于Employee（员工）的业务逻辑
 */
public class EmployeeService {
    private static EmployeeDao employeeDao = new EmployeeDaoImpl();

    /**
     * 分页返回所有员工信息
     * @return 所有员工信息组成的List
     */
    public static List<EmployeeCustom> findEmployeeLimit(int page){
        List<EmployeeCustom> employees = null;
        try {
            employees = employeeDao.findEmployeeLimitInDetail(page);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
