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

/**
 * 关于user（用户）的业务逻辑层
 */
public class UserService {
    private UserDao userDao = new UserDaoImpl();

    /**
     * 增加一个user，先判断是否存在该user的username，如果不存在则添加
     * 然后判断增加的用户的属性，并在Client（顾客）表或Employee（员工）表中添加相应的信息
     * @param user 要添加的user信息
     * @return 添加成功返回true，添加失败则返回false
     */
    public boolean addUser(User user, Object type) {
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
}
