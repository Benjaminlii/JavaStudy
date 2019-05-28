package servlet;

import entity.Client;
import entity.Employee;
import entity.User;
import net.sf.json.JSONObject;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends javax.servlet.http.HttpServlet {
    /**
     * 处理注册请求
     * 成功会返回1，失败返回0（json，key为rtn）
     */
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //提取请求中的数据，封装成对象，u_id将在user添加成功后查询得到
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String e_name = request.getParameter("e_name");
        int s_id = Integer.valueOf(request.getParameter("s_id"));
        int d_id = Integer.valueOf(request.getParameter("d_id"));
        User user = new User(d_id, username, password);
        Object type = null;
        if (d_id == 8) {//顾客client
            type = new Client();
            request.getSession().setAttribute("client", type);
        } else {
            type = new Employee(e_name, 3000, s_id, d_id);
            request.getSession().setAttribute("employee", type);
        }
        //输出
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        if (UserService.registerUser(user, type)) {
            jsonObject.put("rtn", 1);
        }else{
            jsonObject.put("rtn", 0);
        }
        pw.print(jsonObject);
        pw.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
