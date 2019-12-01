package textJDBC;

import java.sql.*;
import java.util.Scanner;


/**
 * ---------------------------------------------------------------------------------------------------------------------
 * Statement接口：用于执行静态的SQL语句并返回所执行的结果
 * ---------------------------------------------------------------------------------------------------------------------
 * Statement:由createStatement创建，用于发送简单SQL语句
 * ····|- PreparedStatement：继承自Statement，由PreparedStatement创建
 * ················用于发送一个或多个有参数的SQL语句，且效率更高，一般使用这个
 * ········|- CallableStatement：继承自PreparedStatement，用于调用存储过程
 * ---------------------------------------------------------------------------------------------------------------------
 * 常用Statement方法：
 * ····execute（）；运行语句，返回是否有结果
 * ····executeQuery（）；运行select语句，返回ResultSet结果集
 * ····executeUpdate（）；运行insert/update/delete操作，返回更新的行数
 * ---------------------------------------------------------------------------------------------------------------------
 * 在日常使用当中通常不使用Statement对象
 * Statement处理参数十分不方便，而且会发生SQL注入的危险
 * ····SQL注入：在SQL语句的拼接中，传入参数的不正确会造成歧义（例如，传入了where子句 id = 1 or 1 = 1;）
 * ---------------------------------------------------------------------------------------------------------------------
 * 通常使用PreparedStatement
 * PreparedStatement pst = con.prepareStatement(str);
 * str中可以使用？进行占位，然后使用setObject（）等函数进行完善
 * ---------------------------------------------------------------------------------------------------------------------
 * author:Benjamin
 * date:2019.4.14
 * ---------------------------------------------------------------------------------------------------------------------
 */

public class TextStatement {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        m2();
    }

    private static void m1() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/demo?characterEncoding=UTF8&serverTimezone=UTC",
                "root",
                "litao.");

        Statement sta = con.createStatement();
        String str = "insert into student (s_name, course) value ('lilili', 'web');";
        // Statement传入参数使用拼接字符串
        sta.execute(str);

    }

    private static void m2() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?characterEncoding=UTF8&serverTimezone=UTC", "root", "litao.");

        //使用？占位，然后调用setObject（）等函数进行填充
        String str = "insert into student (s_name, course) value (?, ?);";
        PreparedStatement pst = con.prepareStatement(str);
        Scanner in = new Scanner(System.in);
        pst.setObject(1, in.nextLine());
        pst.setObject(2, in.nextLine());
        pst.execute();

    }
}
