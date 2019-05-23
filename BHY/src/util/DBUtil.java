package util;

import java.sql.*;

/**
 * 数据库帮助类
 */
public class DBUtil {
    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;

    /**
     * 对数据库进行连接
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
     * 对数据库进行更新操作
     * @param sql 进行更新操作的SQL语句
     * @param para SQL语句中的参数
     * @return 更新数据的条数
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
     * 对数据库进行查找操作
     * @param sql 进行查找操作的SQL语句
     * @param para SQL语句中的参数
     * @return 查找操作返回的结果集ResultSet对象
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
     * 关闭所有的资源，包括ResultSet、PreparedStatement和connection。
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
