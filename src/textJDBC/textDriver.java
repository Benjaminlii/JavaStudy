package textJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ---------------------------------------------------------------------------------------------------------------------
 * JDBC
 * ����ѧϰdriver
 * ������jdbc��jar����https://blog.csdn.net/diligentkong/article/details/79587464
 * ---------------------------------------------------------------------------------------------------------------------
 * �������ݿ�����Ҫ���ľ��Ǽ���������Driver
 * ��������Class.forName("com.mysql.cj.jdbc.Driver");
 * Ȼ��ͨ��DriverManager��������
 * ��������Connection con = DriverManager.getConnection("url", "userName", "passWorld");
 * ��������MySQL��JDBC URL��д��ʽ��jdbc:mysql://�������ƣ����Ӷ˿�/���ݿ������?����=ֵ&����=ֵ
 * ��������������Ҫ��url�������ַ�����ʱ��
 * ��������������urlΪ��jdbc:mysql://localhost:3306/demo?characterEncoding=UTF8&serverTimezone=UTC
 * �������Ӷ��ȽϺ�ʱ���Ժ�ͨ��ʹ�����ӳ����������Ӷ���
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
