package studentDemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 建立数据库连接
 */
public class DBDao {
    private static Connection con = null;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/web?characterEncoding=UTF8&serverTimezone=UTC";
            String USERNAME = "root";
            String PASSWORD = "litao.";
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon() {
        return con;
    }
}
