package servlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FindEmployeeLimitServlet")
public class FindEmployeeLimitServlet extends HttpServlet {
    /**
     * 分页查询所有的员工详细信息
     * 参数：页码
     * 返回值：[{"d_id":41,"e_age":0,"e_id":3,"e_name":"C","e_salary":5000,"e_sex":"","e_time":null,"e_type":"店长","s_id":1,"st_name":"","u_id":0,"username":""}]
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONArray employees = null;

        //封装数据
        int page = Integer.valueOf(request.getParameter("page"));

        //调用业务逻辑
        employees = JSONArray.fromObject(EmployeeService.findEmployeeLimit(page));

        //输出
        pw.print(employees);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
