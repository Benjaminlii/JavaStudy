package loginWithDBMS;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Check")
public class CheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Acc acc = new Acc(request.getParameter("uname"), request.getParameter("upwd"));
        LoginDao login = new LoginDao();

        PrintWriter out = response.getWriter();

        if (login.login(acc) <= 0) {
            out.println("error");
        } else {
            out.println("get it");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }
}
