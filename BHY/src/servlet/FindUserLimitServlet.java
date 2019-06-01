package servlet;

import entity.Page;
import entity.User;
import entity.UserCustom;
import entity.UserQueryVo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/FindUserLimitServlet")
public class FindUserLimitServlet extends HttpServlet {
    /**
     * 分页查询用户
     * 根据session中的user对象的类型判断是否能进行查询(通过判断user对象的d_id属性来得到当前用户的类型)
     * 返回值：json类型，如果当前状态为未登录，put("ifLogin", "false")并进行页面跳转
     * 如果已登陆，但权限不是店长，put("ifLogin", "true")，put("isLord", "false")由前端进行提示
     * 如果是店长登陆put("ifLogin", "true")，put("isLord", "true")，jsonObject.put("users", users)
     * 最后的users是json格式的List<User>
     * if(json.hasOwnProperty("KEY"))  js中判断key是否存在
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();

        //封装数据
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        try {
            BeanUtils.populate(userCustom, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        userQueryVo.setUserCustom(userCustom);
        String page = request.getParameter("page");
        if (!"".equals(page) && page != null) {
            userQueryVo.setPage(new Page(Integer.valueOf(page)));
        }

        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            //当前已经有登陆状态
            jsonObject.put("ifLogin", true);
            jsonObject.put("users", JSONArray.fromObject(UserService.findUserLimitInDetail(userQueryVo)));
        } else {
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
