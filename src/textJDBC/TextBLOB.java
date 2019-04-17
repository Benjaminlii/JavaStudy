package textJDBC;

import java.io.*;
import java.sql.*;

/**
 * ---------------------------------------------------------------------------------------------------------------------
 * 向数据库中存入大二进制文件
 * 和CLOB一样，需要使用流进行文件的传输
 * 这里传输二进制文件。那么就需要使用字节流
 * ---------------------------------------------------------------------------------------------------------------------
 * <p>
 * author:Benjamin
 * date:2019.4.16
 * ---------------------------------------------------------------------------------------------------------------------
 */
public class TextBLOB {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        read();
    }

    /**
     * 通过JDBC向MySQL数据库中上传大二进制文件
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws FileNotFoundException
     */
    public static void write() throws ClassNotFoundException, SQLException, FileNotFoundException {
        // 连接数据库
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
     * 从MySQL数据库读取大二进制文件
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    public static void read() throws ClassNotFoundException, SQLException, IOException {
        // 连接数据库
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
