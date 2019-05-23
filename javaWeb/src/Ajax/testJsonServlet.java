package Ajax;

import net.sf.json.JSONObject;
import studentDemo.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/testJsonServlet")
public class testJsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        JSONObject json = new JSONObject();
        json.put("stu1", new Student("Benjamin", 19, "xa"));
        json.put("stu2", new Student("lt", 18, "bj"));
        json.put("stu3", new Student("llf", 20, "kel"));

        PrintWriter out = response.getWriter();
        System.out.println(json);
        out.print(json);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
