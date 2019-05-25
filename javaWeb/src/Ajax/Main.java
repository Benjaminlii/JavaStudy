package Ajax;

import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Main")
public class Main extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + ", " + password);
        JSONObject jsonObject = new JSONObject();

        if ("zhangzhaowei".equals(username) && "12345678".equals(password)) {
            jsonObject.put("rtn", "1");
        } else {
            jsonObject.put("rtn", "0");
        }
        PrintWriter pw = response.getWriter();
        System.out.println(jsonObject);
        pw.print(jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
