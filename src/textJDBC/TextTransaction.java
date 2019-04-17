package textJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ---------------------------------------------------------------------------------------------------------------------
 * 使用JDBC完成事务
 * ---------------------------------------------------------------------------------------------------------------------
 * 事务在MySQL中预警学习过，需要先设置状态为非自动提交
 * 在JDBC中，通过try-catch完成事务中语句的正确性判断，并在catch中进行回滚
 * ---------------------------------------------------------------------------------------------------------------------
 * 本测试中将各种异常都进行了捕获，以前没有做过演示。
 * ---------------------------------------------------------------------------------------------------------------------
 * author:Benjamin
 * date:2019.4.15
 * ---------------------------------------------------------------------------------------------------------------------
 */

public class TextTransaction {
    public static void main(String[] args) throws ClassNotFoundException {
        // 连接数据库
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demo?characterEncoding=UTF8&serverTimezone=UTC",
                    "root",
                    "litao.");

            con.setAutoCommit(false);

            String str = "insert into student (s_name, course)value(?, ?);";
            ps1 = con.prepareStatement(str);
            ps1.setObject(1,"litao123");
            ps1.setObject(2,"MySQL");
            ps1.execute();

            // 这里故意出错测试是否会回滚
            str = "insert into student (s_name, course)value(?, ?, ?);";
            ps2 = con.prepareStatement(str);
            ps2.setObject(1,"litao123");
            ps2.setObject(2,"MySQL_");
            ps2.execute();

            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            if(ps1 != null){
                try {
                    ps1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps2 != null){
                try {
                    ps2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
