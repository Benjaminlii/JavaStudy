package loginWithDBMS;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/Check")
public class CheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rtn = 0;
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        Acc acc = new Acc(uname,upwd);
        try {
            LoginDao login = new LoginDao("root", "litao.", "web");
            rtn = login.login(acc);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        if(rtn <= 0){
            out.println("error");
        }else{
            out.println("get it");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
