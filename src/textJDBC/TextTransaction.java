package textJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ---------------------------------------------------------------------------------------------------------------------
 * ʹ��JDBC�������
 * ---------------------------------------------------------------------------------------------------------------------
 * ������MySQL���Ѿ�ѧϰ������Ҫ������״̬Ϊ���Զ��ύ
 * ��JDBC�У�ͨ��try-catch���������������ȷ���жϣ�����catch�н��лع�
 * ---------------------------------------------------------------------------------------------------------------------
 * �������н������쳣�������˲�����ǰû��������ʾ��
 * ---------------------------------------------------------------------------------------------------------------------
 * author:Benjamin
 * date:2019.4.15
 * ---------------------------------------------------------------------------------------------------------------------
 */

public class TextTransaction {
    public static void main(String[] args) throws ClassNotFoundException {
        // �������ݿ�
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

            // ��������������Ƿ��ع�
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
