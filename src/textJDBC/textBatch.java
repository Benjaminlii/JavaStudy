package textJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ---------------------------------------------------------------------------------------------------------------------
 * ������Batch
 * JDBC�ṩ�����ݿ�batch����������������ݴ�����������������ɾ���ȣ�������¿��Դ��������ϵͳ������
 * ���������������ʱ��ͨ��Ӧ�ùر��Զ�ִ�С�
 * ---------------------------------------------------------------------------------------------------------------------
 * �����൱�ڽ�SQL�����������ύʱһ���ύ����DBMSͳһ����
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
        // �������ݿ�
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/demo?characterEncoding=UTF8&serverTimezone=UTC",
                "root",
                "litao.");

        // ��ȡStatement�����ﲻʹ��prepareStatement��ԭ����ƴ��SQLЧ����Щ��
        Statement sta = con.createStatement();
        // ����Ϊ���Զ��ύ
        con.setAutoCommit(false);
        //ѭ������20000������
        for(int i = 1; i <= 20000; i++){
            //��ƴ�ӵõ���SQL�����ӵ�Batch��
            sta.addBatch("insert into table1 (name, time_) value ('name" + i + "', now());");
        }
        // �ύ��䣬��DBMS
        sta.executeBatch();
        // ִ�����
        con.commit();

        // �ر���Դ
        sta.close();
        con.close();
    }
}
