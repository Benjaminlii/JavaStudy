package service;

import dao.ClientDaoImpl;
import dao.EmployeeDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import entity.Client;
import entity.Employee;
import entity.User;
import util.DBUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * 关于user（用户）的业务逻辑层
 */
public class UserService {
    private static UserDao userDao = new UserDaoImpl();

    /**
     * 注册
     * 增加一个user，先判断是否存在该user的username，如果不存在则添加
     * 然后判断增加的用户的属性，并在Client（顾客）表或Employee（员工）表中添加相应的信息
     * @param user 要添加的user信息
     * @return 添加成功返回true，添加失败则返回false
     */
    public static boolean registerUser(User user, Object type) {
        boolean rtn = false;
        try {
            DBUtil.getCon().setAutoCommit(false);
            if (!userDao.isUserExist(user.getUsername()) && (user.getD_id() == 8 || user.getD_id() == 9)) {
                if(user.getD_id() == 8) {
                    Client client = (Client)type;
                    boolean rtn1 = userDao.addUser(user);
                    client.setU_id(userDao.findUserByUserName(user.getUsername()).getU_id());
                    boolean rtn2 = new ClientDaoImpl().addClient(client);
                    rtn = rtn1 && rtn2;
                }else {
                    Employee employee = (Employee)type;
                    boolean rtn1 = userDao.addUser(user);
                    employee.setU_id(userDao.findUserByUserName(user.getUsername()).getU_id());
                    boolean rtn2 = new EmployeeDaoImpl().addEmployee(employee);
                    rtn = rtn1 && rtn2;
                }
                DBUtil.getCon().commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try{
                DBUtil.getCon().rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return rtn;
    }

    /**
     * 登陆用户
     * 根据用户名进行查询
     * 如果查询到并且密码匹配，则返回完整的User对象
     * 如果查询到但密码不匹配，则返回password为null的User对象
     * 有servlet得到该对象之后进行判断将要进行的操作
     * @param user 登陆页面所填写信息封装成的User对象
     * @return 如果查询到并且密码匹配，则返回完整的User对象；如果查询到但密码不匹配，则返回password为null的User对象
     */
    public static User loginUser(User user){
        User rtn = null;
        try {
            rtn = userDao.findUserByUserName(user.getUsername());
            //查询到user对象，并进行密码的判断
            if(rtn != null){
                //有效用户名
                if(!user.getPassword().equals(rtn.getPassword())){
                    //无效密码
                    rtn.setPassword(null);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }

    /**
     * 查询所有的User（用户）对象
     * @return 返回list
     */
    public static List<User> selectAllUser(){
        List<User> users = null;
        try {
            users =  userDao.findAllUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
