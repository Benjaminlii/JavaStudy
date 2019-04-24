package textJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ---------------------------------------------------------------------------------------------------------------------
 * JDBC
 * 首先学习driver
 * 如何添加jdbc的jar包：https://blog.csdn.net/diligentkong/article/details/79587464
 * ---------------------------------------------------------------------------------------------------------------------
 * 连接数据库首先要做的就是加载驱动类Driver
 * ····Class.forName("com.mysql.cj.jdbc.Driver");
 * 然后通过DriverManager建立连接
 * ····Connection con = DriverManager.getConnection("url", "userName", "passWorld");
 * ····MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值&参数=值
 * ····这里需要在url种设置字符集和时区
 * ····完整的url为：jdbc:mysql://localhost:3306/demo?characterEncoding=UTF8&serverTimezone=UTC
 * 建立链接都比较耗时，以后通常使用连接池来管理连接对象；
 * ---------------------------------------------------------------------------------------------------------------------
 * author:Benjamin
 * date:2019.4.14
 * ---------------------------------------------------------------------------------------------------------------------
 */

public class TextDriver {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/world",
                "root",
                "litao.");

    }
}
