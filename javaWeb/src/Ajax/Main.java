package Ajax;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Main")
public class Main extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = new ArrayList<>();
        users.add(new User(1, 9, "zzw", "123123"));
        users.add(new User(2, 9, "llf", "123123"));
        users.add(new User(3, 8, "lt", "123123"));
        users.add(new User(4, 8, "lh", "123123"));
        users.add(new User(5, 8, "yjb", "123123"));
        users.add(new User(6, 9, "hha", "123123"));
        users.add(new User(7, 9, "aaa", "123123"));
        JSONArray jsonArray = JSONArray.fromObject(users);

        PrintWriter pw = response.getWriter();

        pw.print(jsonArray);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
