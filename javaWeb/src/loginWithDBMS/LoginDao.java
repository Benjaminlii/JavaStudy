package loginWithDBMS;

import java.sql.*;

public class LoginDao {

    private Connection con;
    private PreparedStatement ps = null;

    public LoginDao(String username, String password, String database) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + database + "?characterEncoding=UTF8&serverTimezone=UTC",
                username,
                password);
    }

    public int login(Acc acc) throws SQLException {
        String sql = "select * from acc where uname = ? and upwd = ?;";

        ps = con.prepareStatement(sql);

        ps.setObject(1, acc.getUname());
        ps.setObject(2, acc.getUpwd());

        ResultSet rs = ps.executeQuery();
        int rtn = 0;
        while(rs.next()){
            rtn++;
        }
        return rtn;
    }
}
