package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * �����ݿ��������
 */
public class DBDao {
    private static Connection con = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web?characterEncoding=UTF8&serverTimezone=UTC"
                    , "root"
                    , "litao.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * �õ����ݿ�����
     * @return �������Ӻõ����ݿ��Connection����
     */
    public static Connection getCon() {
        return con;
    }
}
