package textJDBC;

import java.sql.*;
import java.util.Scanner;


/**
 * ---------------------------------------------------------------------------------------------------------------------
 * Statement�ӿڣ�����ִ�о�̬��SQL��䲢������ִ�еĽ��
 * ---------------------------------------------------------------------------------------------------------------------
 * Statement:��createStatement���������ڷ��ͼ�SQL���
 * ��������|- PreparedStatement���̳���Statement����PreparedStatement����
 * �����������������������������������ڷ���һ�������в�����SQL��䣬��Ч�ʸ��ߣ�һ��ʹ�����
 * ����������������|- CallableStatement���̳���PreparedStatement�����ڵ��ô洢����
 * ---------------------------------------------------------------------------------------------------------------------
 * ����Statement������
 * ��������execute������������䣬�����Ƿ��н��
 * ��������executeQuery����������select��䣬����ResultSet�����
 * ��������executeUpdate����������insert/update/delete���������ظ��µ�����
 * ---------------------------------------------------------------------------------------------------------------------
 * ���ճ�ʹ�õ���ͨ����ʹ��Statement����
 * Statement�������ʮ�ֲ����㣬���һᷢ��SQLע���Σ��
 * ��������SQLע�룺��SQL����ƴ���У���������Ĳ���ȷ��������壨���磬������where�Ӿ� id = 1 or 1 = 1;��
 * ---------------------------------------------------------------------------------------------------------------------
 * ͨ��ʹ��PreparedStatement
 * PreparedStatement pst = con.prepareStatement(str);
 * str�п���ʹ�ã�����ռλ��Ȼ��ʹ��setObject�����Ⱥ�����������
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
        // Statement�������ʹ��ƴ���ַ���
        sta.execute(str);

    }

    private static void m2() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?characterEncoding=UTF8&serverTimezone=UTC", "root", "litao.");

        //ʹ�ã�ռλ��Ȼ�����setObject�����Ⱥ����������
        String str = "insert into student (s_name, course) value (?, ?);";
        PreparedStatement pst = con.prepareStatement(str);
        Scanner in = new Scanner(System.in);
        pst.setObject(1, in.nextLine());
        pst.setObject(2, in.nextLine());
        pst.execute();

    }
}
