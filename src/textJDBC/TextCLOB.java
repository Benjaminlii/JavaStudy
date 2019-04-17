package textJDBC;

import java.io.*;
import java.sql.*;

/**
 * ---------------------------------------------------------------------------------------------------------------------
 * ������MySQL���ݿ���д����ı�����
 * ��Ѱ�����ݲ�ͬ�����ı�������Ҫʹ���������ݿ���д��
 * ---------------------------------------------------------------------------------------------------------------------
 * author:Benjamin
 * date:2019.4.15
 * ---------------------------------------------------------------------------------------------------------------------
 */
public class TextCLOB {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        read();
    }

    /**
     * ʹ��JDBC��MySQL���ݿ���д����ַ��ļ�
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
        // ִ��SQL���
        String str = "insert into test_clob (text)value(?);";
        PreparedStatement ps = con.prepareStatement(str);
        // ������������sql
        ps.setClob(1,
                new FileReader(
                        new File("src\\textJDBC\\one.txt")));
        ps.executeUpdate();
    }

    /**
     * ʹ��JDBC��MySQL��ȡ���ı�����
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
        String str = "select * from test_clob where id = ?;";
        PreparedStatement ps = con.prepareStatement(str);
        ps.setObject(1, 1);

        ResultSet rs = ps.executeQuery();

        // ͨ��Buffer���Ч�ʣ���ȡ���ݲ�д�ڱ���
        while (rs.next()) {
            Clob clob = rs.getClob("text");
            BufferedReader bfr = new BufferedReader(clob.getCharacterStream());
            BufferedWriter bfw = new BufferedWriter(
                    new FileWriter("src\\textJDBC\\one(writeFromMySQL).txt"));

            String s;
            while ((s = bfr.readLine()) != null){
                bfw.write(s);
                bfw.newLine();
                bfw.flush();
            }
        }
    }
}
