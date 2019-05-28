package dao;

import entity.User;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean addUser(User user) {
        String sql = "insert into user (d_id, username, password) " +
                "values (?,?,?);";
        Object[] para = {
                user.getD_id(), user.getUsername(), user.getPassword()
        };
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public boolean deleteUser(int u_id) {
        String sql = "delete from user where u_id = ?";
        Object[] para = {u_id};
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "update user set username = ?, password = ? " +
                "where username = ?";
        Object[] para = {
                user.getUsername(), user.getPassword(), user.getUsername()
        };
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public List<User> findAllUser() throws SQLException {
        String sql = "select * from user;";
        ResultSet resultSet = DBUtil.executeQuery(sql, null);
        List<User> rtn = new ArrayList<>();
        User user;
        while (resultSet.next()) {
            user = new User(
                    resultSet.getInt("u_id"),
                    resultSet.getInt("d_id"),
                    resultSet.getString("username"),
                    resultSet.getString("password")
            );
            rtn.add(user);
        }
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public User findUserByUserName(String username) throws SQLException {
        String sql = "select * from user where username = ?;";
        Object[] para = {username};
        ResultSet resultSet = DBUtil.executeQuery(sql, para);
        User user = null;
        if (resultSet.next()) {
            user = new User(
                    resultSet.getInt("u_id"),
                    resultSet.getInt("d_id"),
                    resultSet.getString("username"),
                    resultSet.getString("password")
            );
        }
        DBUtil.closeAll();
        return user;
    }

    @Override
    public boolean isUserExist(String username) throws SQLException {
        return findUserByUserName(username) != null;
    }
}
