package servlet;

import entity.EmployeeCustom;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
    /**
     * 删除一条员工信息
     * 要删除的员工的信息，只需要填充e_id字段
     * 删除成功返回rtn:1，否则返回rtn:0
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();

        //封装数据
        EmployeeCustom employeeCustom = new EmployeeCustom();
        try {
            BeanUtils.populate(employeeCustom, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用业务逻辑
        if(EmployeeService.deleteEmployee(employeeCustom)){
            jsonObject.put("rtn", 1);
        }else {
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
