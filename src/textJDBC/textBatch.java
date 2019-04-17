package textJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ---------------------------------------------------------------------------------------------------------------------
 * 批处理Batch
 * JDBC提供了数据库batch处理的能力，在数据大批量操作（新增、删除等）的情况下可以大幅度提升系统的性能
 * 当进行批处理更新时，通常应该关闭自动执行。
 * ---------------------------------------------------------------------------------------------------------------------
 * 这里相当于将SQL语句存起来，提交时一起提交，由DBMS统一处理
 * ---------------------------------------------------------------------------------------------------------------------
 * author:Benjamin
 * date:2019.4.15
 * ---------------------------------------------------------------------------------------------------------------------
 */

public class TextBatch {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        m1();
    }
    private static void m1() throws ClassNotFoundException, SQLException {
        // 连接数据库
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/demo?characterEncoding=UTF8&serverTimezone=UTC",
                "root",
                "litao.");

        // 获取Statement，这里不使用prepareStatement，原因是拼接SQL效率有些低
        Statement sta = con.createStatement();
        // 设置为不自动提交
        con.setAutoCommit(false);
        //循环插入20000行数据
        for(int i = 1; i <= 20000; i++){
            //将拼接得到的SQL语句添加到Batch中
            sta.addBatch("insert into table1 (name, time_) value ('name" + i + "', now());");
        }
        // 提交语句，到DBMS
        sta.executeBatch();
        // 执行语句
        con.commit();

        // 关闭资源
        sta.close();
        con.close();
    }
}
