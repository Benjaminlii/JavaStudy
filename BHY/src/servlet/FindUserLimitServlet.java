package servlet;

import entity.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/FindUserLimitServlet")
public class FindUserLimitServlet extends HttpServlet {
    /**
     * 分页查询用户
     * 根据session中的user对象的类型判断是否能进行查询(通过判断user对象的d_id属性来得到当前用户的类型)
     * 返回值：json类型，如果当前状态为未登录，put("ifLogin", "false")并进行页面跳转
     *                  如果已登陆，但权限不是店长，put("ifLogin", "true")，put("isLord", "false")由前端进行提示
     *                  如果是店长登陆put("ifLogin", "true")，put("isLord", "true")，jsonObject.put("users", users)
     *                                  最后的users是json格式的List<User>
     * if(json.hasOwnProperty("KEY"))  js中判断key是否存在
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = null;
        List<User> users = null;

        User user = (User) request.getSession().getAttribute("user");
        int page = Integer.valueOf(request.getParameter("page"));
        if(user != null){
            //当前已经有登陆状态
            jsonObject.put("ifLogin", true);
            if(user.getD_id() == 41){
                //权限为店长
                jsonObject.put("isLord", true);
                users = UserService.selectUserLimit(page);
                jsonArray = JSONArray.fromObject(users);
                jsonObject.put("users", jsonArray);
            }else{
                jsonObject.put("isLord", false);
            }
        }else{
            //没有登陆
            jsonObject.put("ifLogin", false);
        }
        pw.print(jsonObject);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
