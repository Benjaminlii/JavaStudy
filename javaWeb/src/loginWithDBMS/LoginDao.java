package loginWithDBMS;

import java.sql.*;

class LoginDao {

    LoginDao(){
    }

    int login(Acc acc) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rtn = -1;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/web?characterEncoding=UTF8&serverTimezone=UTC",
                    "root",
                    "litao.");
            String sql = "select count(*) from acc where uname = ? and upwd = ?;";

            ps = con.prepareStatement(sql);

            ps.setString(1, acc.getUname());
            ps.setString(2, acc.getUpwd());
            rs = ps.executeQuery();
            while (rs.next()) {
                rtn = rs.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return rtn;
    }
}
