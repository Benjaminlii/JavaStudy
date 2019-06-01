package service;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import entity.EmployeeCustom;
import entity.EmployeeQueryVo;
import main.config.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * 关于Employee（员工）的业务逻辑
 */
public class EmployeeService {
    private static SqlSessionFactory sqlSessionFactory;

    static  {
        try (
                InputStream inputStream = Resources.getResourceAsStream("main/config/SqlMapConfig.xml")
        ) {
            EmployeeService.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * [分页][条件]查询员工信息
     * @param employeeQueryVo 查询信息和分页信息
     * @return 查询出的员工信息
     */
    public static List<EmployeeCustom> findEmployeeLimitInDetail(EmployeeQueryVo employeeQueryVo){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        List<EmployeeCustom> employeeCustoms = null;
        try {
            employeeCustoms = employeeMapper.findEmployeeLimitInDetail(employeeQueryVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeCustoms;
    }



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
