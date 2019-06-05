package service;

import entity.EmployeeCustom;
import entity.EmployeeQueryVo;
import main.config.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
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

    /**
     * 更新员工信息
     * @param employeeCustom 包装更新信息，e_id为检索信息，其他为更新信息
     *                       可以更新的信息：姓名e_name，工资e_salary，所属宠物店st_id，职务d_id，年龄e_age
     * @return 更新成功返回true，否则返回false
     */
    public static boolean updateEmployee(EmployeeCustom employeeCustom){
        boolean rtn = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        try {
            rtn = employeeMapper.updateEmployee(employeeCustom);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rtn;
    }

    /**
     * 删除一条员工信息
     * @param employeeCustom 要删除的员工的信息，只需要填充e_id字段
     * @return 删除成功返回true，否则返回false
     */
    public static boolean deleteEmployee(EmployeeCustom employeeCustom){
        boolean rtn = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        try {
            rtn = employeeMapper.deleteEmployee(employeeCustom.getE_id());
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rtn;
    }
}
