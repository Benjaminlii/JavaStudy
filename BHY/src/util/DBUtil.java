package util;

import java.sql.*;

/**
 * ���ݿ������
 */
public class DBUtil {
    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;

    /**
     * �����ݿ��������
     */
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/bhy?characterEncoding=UTF8&serverTimezone=UTC";
            String USERNAME = "root";
            String PASSWORD = "litao.";
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * �����ݿ���и��²���
     * @param sql ���и��²�����SQL���
     * @param para SQL����еĲ���
     * @return �������ݵ�����
     */
    public static int executeUpdate(String sql, Object[] para) {
        int count = 0;
        try {
            ps = con.prepareStatement(sql);
            if(para != null) {
                for (int i = 0; i < para.length; i++) {
                    ps.setObject(i + 1, para[i]);
                }
            }
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll();
        }
        return count;
    }

    /**
     * �����ݿ���в��Ҳ���
     * @param sql ���в��Ҳ�����SQL���
     * @param para SQL����еĲ���
     * @return ���Ҳ������صĽ����ResultSet����
     */
    public static ResultSet executeQuery(String sql, Object[] para) {
        try {
            ps = con.prepareStatement(sql);
            if(para != null) {
                for (int i = 0; i < para.length; i++) {
                    ps.setObject(i + 1, para[i]);
                }
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * �ر����е���Դ������ResultSet��PreparedStatement��connection��
     */
    public static void closeAll() {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null) ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
