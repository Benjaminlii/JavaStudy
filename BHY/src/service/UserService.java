package service;

import dao.ClientDaoImpl;
import dao.EmployeeDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import entity.*;
import main.config.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import util.DBUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * 关于user（用户）的业务逻辑层
 */
public class UserService {
    private static SqlSessionFactory sqlSessionFactory;

    static  {
        try (
                InputStream inputStream = Resources.getResourceAsStream("main/config/SqlMapConfig.xml")
        ) {
            UserService.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    private static UserDao userDao = new UserDaoImpl();

    /**
     * 注册
     * 增加一个user，先判断是否存在该user的username，如果不存在则添加
     * 然后判断增加的用户的属性，并在Client（顾客）表或Employee（员工）表中添加相应的信息
     *
     * @param user 要添加的user信息
     * @return 添加成功返回true，添加失败则返回false
     */
    public static boolean registerUser(UserQueryVo userQueryVo, EmployeeQueryVo employeeQueryVo) {
        boolean rtn = false;

        userQueryVo.getUserCustom().setPassword(null);


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

        List<UserCustom> userCustoms;
        UserCustom userCustom = null;
        String password = userQueryVo.getUserCustom().getPassword();
        userQueryVo.getUserCustom().setPassword(null);

        try {
            userCustoms = userMapper.findUserLimitInDetail(userQueryVo);
            if(userCustoms.size() >= 1) {
                userCustom = userCustoms.get(0);
                //有效用户名
                if (!userCustom.getPassword().equals(password)) {
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
     * 查询所有的User（用户）对象
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
     * @param user 传入的新数据，其中用户名指定要进行更新的用户
     * @return 用户不存在返回false，存在且更新成功返回true
     */
    public static boolean updateUser(User user){
        boolean rtn = false;
        try {
            if(userDao.isUserExist(user.getUsername())){
                //该用户存在
                rtn = userDao.updateUser(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }
}
