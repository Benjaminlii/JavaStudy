package textJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 开JDBC
 * 首先学习driver
 * 连接数据库首先要做的就是加载驱动类Driver
 * ····Class.forName("come.mysql.jdbc.Driver");
 * 然后通过DriverManager建立连接
 * ····Connection con = DriverManager.getConnection("jdbc:mysql://host:port/database", "userName", "passWorld");
 * 建立链接都比较耗时，以后通常使用连接池来管理连接对象；
 *
 * author:Benjamin
 * date:2019.4.14
 */

public class textDriver {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("come.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "litao.");

    }
}
