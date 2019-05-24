package dao;

import entity.User;

import java.util.List;

public interface UserDao {
    /**
     * �����ݿ��е�User���û��������������
     * @param user ����ķ�װ�õ�������
     * @return ��ӳɹ�����true�����򷵻�false
     */
    public boolean addUser(User user);

    /**
     * ����u_id��User����ɾ��һ����Ϣ
     * @param u_id ��Ҫɾ������Ϣ��u_id
     * @return ɾ���ɹ�����true�����򷵻�false
     */
    public boolean deleteUser(int u_id);

    /**
     * ���ݴ�����Ϣ����һ��User���е�����
     * @param user �������Ϣ��u_idΪ���Ҹ�����Ϣ���������������ݾ�Ϊ�������޸ĵ�����Ϣ��
     * @return �޸ĳɹ�����true�����򷵻�false
     */
    public boolean updateUser(User user);

    /**
     * ��ѯUser���е�������Ϣ
     * @return �����е�������Ϣ��װ��List<User>���з���
     */
    public List<User> findAllUser();

    /**
     * �����û�����ѯ�û�
     * @param username ��Ҫ��ѯ���û���
     * @return ��ѯ�ɹ����ظ��û�����ѯʧ�ܷ���null
     */
    public User findUserByUserName(String username);

    /**
     * �ж����û����Ƿ����
     * @param username ��Ҫ�����жϵ��û���
     * @return ���ڷ���true�������ڷ���false
     */
    public boolean isUserExist(String username);

//    public User findUserByUserNameAndPassWord(String username, String passworld)
}
