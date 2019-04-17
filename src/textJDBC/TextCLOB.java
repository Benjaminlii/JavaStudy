package textJDBC;

import java.io.*;
import java.sql.*;

/**
 * ---------------------------------------------------------------------------------------------------------------------
 * 可以向MySQL数据库中写入大文本数据
 * 与寻常数据不同，大文本数据需要使用流向数据库中写入
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
     * 使用JDBC向MySQL数据库中写入大字符文件
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
        // 执行SQL语句
        String str = "insert into test_clob (text)value(?);";
        PreparedStatement ps = con.prepareStatement(str);
        // 将读入流传入sql
        ps.setClob(1,
                new FileReader(
                        new File("src\\textJDBC\\one.txt")));
        ps.executeUpdate();
    }

    /**
     * 使用JDBC从MySQL读取大文本数据
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
        String str = "select * from test_clob where id = ?;";
        PreparedStatement ps = con.prepareStatement(str);
        ps.setObject(1, 1);

        ResultSet rs = ps.executeQuery();

        // 通过Buffer提高效率，读取数据并写在本地
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
