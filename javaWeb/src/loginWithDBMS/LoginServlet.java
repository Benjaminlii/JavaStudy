package loginWithDBMS;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");

        Acc acc = new Acc(request.getParameter("uname"), request.getParameter("upwd"));
        LoginDao login = new LoginDao();

        if (login.login(acc) == 1) {
            try {
                request.getRequestDispatcher("/loginWithDBMS/Welcome.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("/javaWeb/loginWithDBMS/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }
}
