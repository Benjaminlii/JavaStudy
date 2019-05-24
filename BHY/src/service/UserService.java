package service;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

/**
 * ����user��ҵ���߼���
 */
public class UserService {
    private UserDao userDao = new UserDaoImpl();

    /**
     * ����һ��user�����ж��Ƿ���ڸ�user��username����������������
     * @param user Ҫ��ӵ�user��Ϣ
     * @return ��ӳɹ�����true�����ʧ���򷵻�false
     */
    public boolean addUser(User user) {
        boolean rtn = false;
        if (!userDao.isUserExist(user.getUsername())) {
            rtn = userDao.addUser(user);
        }
        return rtn;
    }
}
