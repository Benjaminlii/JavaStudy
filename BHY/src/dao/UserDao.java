package dao;

import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 对user表进行的一些原子性操作
 * 增 删（×） 改 查
 */
public class UserDao {
    /**
     * 根据用户名查询User信息
     *
     * @param uName 需要进行查询的用户名
     * @return 查询成功，返回查询到的信息的User对象封装，否则返回null
     */
    public static User findUserByUName(String uName) {
        Connection con = DBDao.getCon();
        PreparedStatement ps = null;
        String sql = "select * from user where uname = ? ;";
        ResultSet rs = null;
        User rtn = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, uName);
            rs = ps.executeQuery();
            if (rs.next()) {
                rtn = new User(rs.getInt("uid")
                        , rs.getString("uname")
                        , rs.getString("upwd")
                        , rs.getString("mobile")
                        , rs.getString("emil")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }

    /**
     * 查询数据库中是否存在该用户
     *
     * @param uName 需要进行查询验证的用户名
     * @return 若存在该用户名，返回true，否则返回false
     */
    public static boolean isExist(String uName) {
        return findUserByUName(uName) != null;
    }

    public static boolean addUser(User user) {
        Connection con = DBDao.getCon();
        PreparedStatement ps = null;
        String sql = "insert into user (uname, upwd, mobile, emil) values (?, ?, ?, ?);";
        int count = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUname());
            ps.setString(2, user.getUpwd());
            ps.setString(3, user.getMobile());
            ps.setString(4, user.getEmil());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count != 0;
    }

    public static boolean upDateUser(String uUname, User user){
        Connection con = DBDao.getCon();
        PreparedStatement ps = null;
        String sql = "update from user set upwd = ?, mobile = ?, emil = ? where uname = ?;";
        int count = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(2, user.getUpwd());
            ps.setString(3, user.getMobile());
            ps.setString(4, user.getEmil());
            ps.setString(1, user.getUname());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count != 0;
    }
}
