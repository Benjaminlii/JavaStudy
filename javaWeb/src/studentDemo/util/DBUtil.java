package studentDemo.util;

import java.sql.*;

public class DBUtil {
    public static Connection con;
    public static PreparedStatement ps;
    public static ResultSet rs;

    public static Connection connectDatabase(String DBName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/" + DBName + "?characterEncoding=UTF8&serverTimezone=UTC";
            String USERNAME = "root";
            String PASSWORD = "litao.";
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static int executeUpdate(String DBName, String sql, Object[] para) {
        DBUtil.connectDatabase(DBName);
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

    public static ResultSet executeQuery(String DBName, String sql, Object[] para) {
        DBUtil.connectDatabase(DBName);
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
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
