package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 对数据库进行连接
 */
public class DBDao {
    private static Connection con = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web?characterEncoding=UTF8&serverTimezone=UTC"
                    , "root"
                    , "litao.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到数据库连接
     * @return 返回连接好的数据库的Connection对象
     */
    public static Connection getCon() {
        return con;
    }
}
