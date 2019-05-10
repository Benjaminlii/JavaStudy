package dao;

import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ��user����е�һЩԭ���Բ���
 * �� ɾ������ �� ��
 */
public class UserDao {
    /**
     * �����û�����ѯUser��Ϣ
     *
     * @param uName ��Ҫ���в�ѯ���û���
     * @return ��ѯ�ɹ������ز�ѯ������Ϣ��User�����װ�����򷵻�null
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
     * ��ѯ���ݿ����Ƿ���ڸ��û�
     *
     * @param uName ��Ҫ���в�ѯ��֤���û���
     * @return �����ڸ��û���������true�����򷵻�false
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
