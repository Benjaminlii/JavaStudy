package servlet;

import entity.UserCustom;
import entity.UserQueryVo;
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
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        try {
            BeanUtils.populate(userCustom, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        userQueryVo.setUserCustom(userCustom);

        //执行逻辑层的调用
        userCustom = UserService.loginUser(userQueryVo);

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        if(userCustom != null){
            //用户名存在
            if(userCustom.getPassword()!=null){
                //密码匹配
                request.getSession().setAttribute("user", userCustom);
                jsonObject.put("rtn", 1);
            }else{
                //密码不匹配
                jsonObject.put("rtn", 2);
            }
        }else{
            //用户名不存在
            jsonObject.put("rtn", 3);
        }
        System.out.println(jsonObject);
        pw.print(jsonObject);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
