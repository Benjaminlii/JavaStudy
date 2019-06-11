package servlet;

import entity.*;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends javax.servlet.http.HttpServlet {
    /**
     * 处理注册请求
     * 目前全部设置成员工注册
     * 注册信息中的用户信息，username和password字段必须被填充
     * 注册信息中的员工信息，e_name、st_id必须被填充
     * 成功会返回1，失败返回0（json，key为rtn）
     */
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //提取请求中的数据，封装成对象，u_id将在user添加成功后查询得到
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        EmployeeQueryVo employeeQueryVo = new EmployeeQueryVo();
        EmployeeCustom employeeCustom = new EmployeeCustom();
        try {
            BeanUtils.populate(userCustom, request.getParameterMap());
            //避免重复且强制设置为员工
            userCustom.setD_id(9);
            BeanUtils.populate(employeeCustom, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        userQueryVo.setUserCustom(userCustom);
        employeeQueryVo.setEmployeeCustom(employeeCustom);

        //输出
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        if (UserService.registerUser(userQueryVo, employeeQueryVo)) {
            jsonObject.put("rtn", 1);
        } else {
            jsonObject.put("rtn", 0);
        }
        pw.print(jsonObject);
        pw.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
