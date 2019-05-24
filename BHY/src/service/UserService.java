package service;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

/**
 * 关于user的业务逻辑层
 */
public class UserService {
    private UserDao userDao = new UserDaoImpl();

    /**
     * 增加一个user，先判断是否存在该user的username，如果不存在则添加
     * @param user 要添加的user信息
     * @return 添加成功返回true，添加失败则返回false
     */
    public boolean addUser(User user) {
        boolean rtn = false;
        if (!userDao.isUserExist(user.getUsername())) {
            rtn = userDao.addUser(user);
        }
        return rtn;
    }
}
