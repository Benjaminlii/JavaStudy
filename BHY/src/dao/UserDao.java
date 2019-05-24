package dao;

import entity.User;

import java.util.List;

public interface UserDao {
    /**
     * 向数据库中的User（用户）表中添加数据
     * @param user 传入的封装好的数对象
     * @return 添加成功返回true，否则返回false
     */
    public boolean addUser(User user);

    /**
     * 根据u_id从User表中删除一条信息
     * @param u_id 需要删除的信息的u_id
     * @return 删除成功返回true，否则返回false
     */
    public boolean deleteUser(int u_id);

    /**
     * 根据传入信息更改一条User表中的数据
     * @param user 传入的信息，u_id为查找该条信息的条件，其他数据均为新数据修改到该信息处
     * @return 修改成功返回true，否则返回false
     */
    public boolean updateUser(User user);

    /**
     * 查询User表中的所有信息
     * @return 将表中的所有信息封装成List<User>进行返回
     */
    public List<User> findAllUser();

    /**
     * 根据用户名查询用户
     * @param username 需要查询的用户名
     * @return 查询成功返回该用户，查询失败返回null
     */
    public User findUserByUserName(String username);

    /**
     * 判读该用户名是否存在
     * @param username 需要进行判断的用户名
     * @return 存在返回true，不存在返回false
     */
    public boolean isUserExist(String username);

//    public User findUserByUserNameAndPassWord(String username, String passworld)
}
