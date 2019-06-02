package servlet;

import entity.UserCustom;
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

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    /**
     * 响应前端发送的更新用户信息（大概就是改密码。。。）的请求
     * 需要传入用户名和新密码
     * 修改成功返回rtn：1
     * 失败返回rtn：0（用户名不存在吧，一般前端规避这种错误，还有可能是数据库访问错误）
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();

        //封装数据
        UserCustom userCustom = new UserCustom();
        try {
            BeanUtils.populate(userCustom, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用业务逻辑
        if(UserService.updateUser(userCustom)){
            jsonObject.put("rtn", 1);
        }else{
            jsonObject.put("rtn", 0);
        }

        //输出
        pw.print(jsonObject);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
