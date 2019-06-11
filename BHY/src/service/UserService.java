package service;

import entity.*;
import main.config.mapper.EmployeeMapper;
import main.config.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 关于user（用户）的业务逻辑层
 */
public class UserService {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try (
                InputStream inputStream = Resources.getResourceAsStream("main/config/SqlMapConfig.xml")
        ) {
            UserService.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册
     * 增加一个user，先判断是否存在该user的username，如果不存在则添加
     * 然后判断增加的用户的属性，并在Client（顾客）表或Employee（员工）表中添加相应的信息
     *
     * @param userQueryVo     注册信息中的用户信息,username和password字段必须被填充
     * @param employeeQueryVo 注册信息中的员工信息，e_name、st_id必须被填充
     * @return 添加成功返回true，并结束事务，添加失败返回false并回滚
     */
    public static boolean registerUser(UserQueryVo userQueryVo, EmployeeQueryVo employeeQueryVo) {
        boolean rtn = false;
        //设置初始工资为5000，职务为服务员
        employeeQueryVo.getEmployeeCustom().setE_salary(5000);
//        employeeQueryVo.getEmployeeCustom().setD_id(43);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        String password = userQueryVo.getUserCustom().getPassword();
        userQueryVo.getUserCustom().setPassword(null);

        try {
            if (userMapper.findUserLimitInDetail(userQueryVo).size() == 0) {
                //用户名不存在，可以创建新用户
                userQueryVo.getUserCustom().setPassword(password);
                if (userMapper.insertUser(userQueryVo.getUserCustom())) {
                    //用户添加成功
                    //将添加的u_id补充到employee的字段中
                    employeeQueryVo.getEmployeeCustom().setU_id(userQueryVo.getUserCustom().getU_id());
                    if (employeeMapper.insertEmployee(employeeQueryVo.getEmployeeCustom())) {
                        //员工也添加成功
                        sqlSession.commit();
                        rtn = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rtn;
    }

    /**
     * 登陆用户
     * 根据用户名进行查询
     * 如果查询到并且密码匹配，则返回完整的User对象
     * 如果查询到但密码不匹配，则返回password为null的User对象
     * 有servlet得到该对象之后进行判断将要进行的操作
     *
     * @param userQueryVo 登陆页面所填写信息封装成的User查询对象
     * @return 如果查询到并且密码匹配，则返回完整的User对象；如果查询到但密码不匹配，则返回password为null的User对象
     */
    public static UserCustom loginUser(UserQueryVo userQueryVo) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserCustom userCustom = null;

        try {
            userCustom = userMapper.findUserByUserName(userQueryVo.getUserCustom().getUsername());
            if (userCustom != null) {
                //有效用户名
                if (!userCustom.getPassword().equals(userQueryVo.getUserCustom().getPassword())) {
                    //无效密码
                    userCustom.setPassword(null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userCustom;
    }

    /**
     * [分页][条件]查询所有的User（用户）对象
     *
     * @return 返回list
     */
    public static List<UserCustom> findUserLimitInDetail(UserQueryVo userQueryVo) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<UserCustom> userCustoms = null;
        try {
            userCustoms = userMapper.findUserLimitInDetail(userQueryVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userCustoms;
    }

    /**
     * 更新传入的用户名对应的用户的信息
     * 先根据用户名进行判空，如果存在，则进行数据的更新
     *
     * @param userCustom 传入的新数据，其中用户名指定要进行更新的用户，密码为新密码
     * @return 用户不存在返回false，存在且更新成功返回true
     */
    public static boolean updateUser(UserCustom userCustom) {
        boolean rtn = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        try {
            rtn = userMapper.updateUser(userCustom);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }
}
