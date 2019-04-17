package textJDBC;

import java.io.*;
import java.sql.*;

/**
 * ---------------------------------------------------------------------------------------------------------------------
 * �����ݿ��д����������ļ�
 * ��CLOBһ������Ҫʹ���������ļ��Ĵ���
 * ���ﴫ��������ļ�����ô����Ҫʹ���ֽ���
 * ---------------------------------------------------------------------------------------------------------------------
 * git�ύ�������⣬����Ϊʱ����ʷ���������˰��췢�����м��ϴ���һ���ļ�̫����
 * ��3����G��GitHub��֧���ϴ���ô���һ���ļ�������Զ�ܾ̾��ύ
 * ����������Ȼص�����git�е�commit�ص�����һ���ύ֮ǰ�������صĴ��ļ�ɾ��֮��
 * ���½���commit��Ȼ��push
 * ---------------------------------------------------------------------------------------------------------------------
 * author:Benjamin
 * date:2019.4.16
 * ---------------------------------------------------------------------------------------------------------------------
 */
public class TextBLOB {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        read();
    }

    /**
     * ͨ��JDBC��MySQL���ݿ����ϴ���������ļ�
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws FileNotFoundException
     */
    public static void write() throws ClassNotFoundException, SQLException, FileNotFoundException {
        // �������ݿ�
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/demo?characterEncoding=UTF8&serverTimezone=UTC",
                "root",
                "litao.");

        String str = "insert into test_blob (png) value (?);";
        PreparedStatement ps = con.prepareStatement(str);
        ps.setBlob(1,
                new FileInputStream("src\\textJDBC\\lion.jpg"));
        ps.executeUpdate();
    }

    /**
     * ��MySQL���ݿ��ȡ��������ļ�
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    public static void read() throws ClassNotFoundException, SQLException, IOException {
        // �������ݿ�
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/demo?characterEncoding=UTF8&serverTimezone=UTC",
                "root",
                "litao.");

        String str = "select png from test_blob where id = 1;";
        PreparedStatement ps = con.prepareStatement(str);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Blob blob = rs.getBlob("png");
            BufferedInputStream bi = new BufferedInputStream(blob.getBinaryStream());
            BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream("src\\textJDBC\\lion(writeFromMySQL).jpg"));

            int i;
            byte[] by = new byte[1024];
            while ((i = bi.read(by)) != -1) {
                bo.write(by, 0, i);
            }
        }
    }

}
