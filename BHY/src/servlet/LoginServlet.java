package servlet;

import entity.User;
import net.sf.json.JSONObject;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    /**
     * 处理登陆请求
     * 如果用户名存在，并且密码匹配，返回json{rtn:"1"}，并将该用户信息绑定到session
     * 如果用户名存在，但密码不匹配，返回json{rtn:"2"};
     * 如果用户名不存在返回json{rtn:"3"};
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //封装response中的数据
        String username =  request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);

        //执行逻辑层的调用，用结果替换user的引用
        user = UserService.loginUser(user);

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        if(user != null){
            //用户名存在
            if(user.getPassword()!=null){
                //密码匹配
                request.getSession().setAttribute("user", user);
                jsonObject.put("rtn", "1");
                response.sendRedirect("/BHY/html/index.html");
            }else{
                //密码不匹配
                jsonObject.put("rtn", "2");
            }
        }else{
            //用户名不存在
            jsonObject.put("rtn", "3");
        }
        pw.print(jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
