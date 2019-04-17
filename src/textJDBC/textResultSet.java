package textJDBC;

import java.sql.*;

/**
 * ---------------------------------------------------------------------------------------------------------------------
 * Statementִ��SQL����Ƿ��صĽ����ResultSet�����
 * ResultSet�ṩ�������������ṩ���͵��ֶ�
 * ��������|- getString();���varchar��char����������
 * ��������|- getFloat();���Float����������
 * ��������|- getDate();���Date����������
 * ��������|- getBoolean();���Boolean����������
 * ---------------------------------------------------------------------------------------------------------------------
 * Statement.executeQuery()�ķ���ֵ��ResultSet
 * ��������ResultSet.next();����ֵΪBoolean����Ϊ�Ƿ���Խ��е�������������е�hasNext()���ƣ��Ҿ����α��ƶ�����
 * ��������getString(int col)��getFloat(int col)��getDate(int col)��getBoolean(int col)�õ�ÿһ�����±�Ϊcol������
 * ---------------------------------------------------------------------------------------------------------------------
 * ResultSet,Statement��Connection����Ҫ�رգ��ر�˳��ResultSet->Statement->Connection
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
        // ʹ��ResultSet���ܷ��صĽ����
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
