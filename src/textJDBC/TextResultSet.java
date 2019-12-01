package textJDBC;

import java.sql.*;

/**
 * ---------------------------------------------------------------------------------------------------------------------
 * Statement执行SQL语句是返回的结果是ResultSet结果集
 * ResultSet提供方法来检索不提供类型的字段
 * ····|- getString();获得varchar，char等数据类型
 * ····|- getFloat();获得Float等数据类型
 * ····|- getDate();获得Date等数据类型
 * ····|- getBoolean();获得Boolean等数据类型
 * ---------------------------------------------------------------------------------------------------------------------
 * Statement.executeQuery()的返回值是ResultSet
 * ····ResultSet.next();返回值为Boolean，意为是否可以进行迭代，与迭代器中的hasNext()类似，且具有游标移动功能
 * ····getString(int col)，getFloat(int col)，getDate(int col)，getBoolean(int col)得到每一行中下标为col的数据
 * ---------------------------------------------------------------------------------------------------------------------
 * ResultSet,Statement和Connection都需要关闭，关闭顺序：ResultSet->Statement->Connection
 * ---------------------------------------------------------------------------------------------------------------------
 * author:Benjamin
 * data:2019.4.15
 * ---------------------------------------------------------------------------------------------------------------------
 */

public class TextResultSet {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        m1();
    }

    private static void m1() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/demo?characterEncoding=UTF8&serverTimezone=UTC",
                "root",
                "litao.");

        String str = "select s_id, s_name, course from student where s_id < ?;";
        PreparedStatement pst = con.prepareStatement(str);
        pst.setObject(1, 10);
        // 使用ResultSet接受返回的结果集
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            System.out.println("id = " + rs.getInt(1) +
                    ", name = " + rs.getString(2) +
                    ", course = " + rs.getString(3));
        }
        pst.close();
        con.close();
    }
}
