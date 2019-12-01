package textJDBC;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * ---------------------------------------------------------------------------------------------------------------------
 * JDBC
 * 首先学习driver
 * 如何添加jdbc的jar包：https://blog.csdn.net/diligentkong/article/details/79587464
 * ---------------------------------------------------------------------------------------------------------------------
 * 连接数据库首先要做的就是加载驱动类Driver
 * ····Class.forName("com.mysql.cj.jdbc.Driver");
 * 然后通过DriverManager建立连接
 * ····Connection con = DriverManager.getConnection("url", "userName", "passWorld");
 * ····MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值&参数=值
 * ····这里需要在url种设置字符集和时区
 * ····完整的url为：jdbc:mysql://localhost:3306/demo?characterEncoding=UTF8&serverTimezone=UTC
 * 建立链接都比较耗时，以后通常使用连接池来管理连接对象；
 * ---------------------------------------------------------------------------------------------------------------------
 * author:Benjamin
 * date:2019.4.14
 * ---------------------------------------------------------------------------------------------------------------------
 */

public class TextDriver {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
//        DriverManager.setLoginTimeout(5);
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://118.31.58.177:3306/db?characterEncoding=UTF8&serverTimezone=UTC",
                "root",
                "123456");
        String str = "select * from student;";
        PreparedStatement pst = con.prepareStatement(str);
        ResultSet rs = pst.executeQuery();

        //创建工作薄对象
        HSSFWorkbook workbook = new HSSFWorkbook();//这里也可以设置sheet的Name
        //创建工作表对象
        HSSFSheet sheet = workbook.createSheet();
        int count = 0;
        HSSFRow firstRow = sheet.createRow(count++);//设置第一行，从零开始
        workbook.setSheetName(0, "TC");//设置sheet的Name
        firstRow.createCell(0).setCellValue("组别");
        firstRow.createCell(1).setCellValue("专业");
        firstRow.createCell(2).setCellValue("学号");
        firstRow.createCell(3).setCellValue("姓名");
        firstRow.createCell(4).setCellValue("电话号码");

        while (rs.next()) {
            //创建工作表的行
            HSSFRow row = sheet.createRow(count++);
            row.createCell(0).setCellValue(rs.getString(4));
            row.createCell(1).setCellValue(rs.getString(3));
            row.createCell(2).setCellValue(rs.getString(1));
            row.createCell(3).setCellValue(rs.getString(2));
            row.createCell(4).setCellValue(rs.getString(5));

            System.out.println("stuId = " + rs.getInt(1) +
                    ", StuName = " + rs.getString(2) +
                    ", major = " + rs.getString(3) +
                    ", direction = " + rs.getString(4) +
                    ", tel = " + rs.getString(5) +
                    ", state = " + rs.getString(6));
        }
        pst.close();
        con.close();
        //文档输出
        FileOutputStream out = new FileOutputStream("/home/benjamin/0110.xls");
        workbook.write(out);
        out.close();

    }

}
