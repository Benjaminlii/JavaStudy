package servlet;

import entity.Client;
import entity.Employee;
import entity.User;
import service.UserService;

import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet("/AddUserServlet")
public class AddUserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //输出
        PrintWriter pw = response.getWriter();
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
        UserService userService = new UserService();
        if (userService.addUser(user, type)) {
//            response.sendRedirect("#");
            pw.write("11111");
        }else{
            pw.write("00000");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
