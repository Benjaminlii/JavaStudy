package textJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ��JDBC
 * ����ѧϰdriver
 * �������ݿ�����Ҫ���ľ��Ǽ���������Driver
 * ��������Class.forName("come.mysql.jdbc.Driver");
 * Ȼ��ͨ��DriverManager��������
 * ��������Connection con = DriverManager.getConnection("jdbc:mysql://host:port/database", "userName", "passWorld");
 * �������Ӷ��ȽϺ�ʱ���Ժ�ͨ��ʹ�����ӳ����������Ӷ���
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
