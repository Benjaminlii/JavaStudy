package servlet;

import entity.EmployeeCustom;
import entity.EmployeeQueryVo;
import entity.Page;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import service.EmployeeService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/FindEmployeeLimitServlet")
public class FindEmployeeLimitServlet extends HttpServlet {
    /**
     * [分页][条件]查询员工信息
     * 参数：查询条件和分页
     * 返回值：[
     *              {"d_id":43,"d_value":"服务员","e_age":0,"e_id":1,"e_name":"A","e_salary":3000,"e_sex":"","e_time":null,"st_address":"","st_id":3,"u_id":0,"username":""},
     *              {"d_id":42,"d_value":"医师","e_age":0,"e_id":2,"e_name":"B","e_salary":4000,"e_sex":"","e_time":null,"st_address":"","st_id":2,"u_id":0,"username":""},
     *              {"d_id":41,"d_value":"店长","e_age":0,"e_id":3,"e_name":"C","e_salary":5000,"e_sex":"","e_time":null,"st_address":"","st_id":1,"u_id":0,"username":""},
     *              {"d_id":42,"d_value":"医师","e_age":0,"e_id":4,"e_name":"D","e_salary":4000,"e_sex":"","e_time":null,"st_address":"","st_id":2,"u_id":0,"username":""}
     *         ]
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONArray employees = null;

        //封装数据
        EmployeeQueryVo employeeQueryVo = new EmployeeQueryVo();
        EmployeeCustom employeeCustom = new EmployeeCustom();
        try {
            BeanUtils.populate(employeeCustom, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        employeeQueryVo.setEmployeeCustom(employeeCustom);
        String page = request.getParameter("page");
        if (!"".equals(page) && page != null) {
            employeeQueryVo.setPage(new Page(Integer.valueOf(page)));
        }

        //调用业务逻辑
        employees = JSONArray.fromObject(EmployeeService.findEmployeeLimitInDetail(employeeQueryVo));

        //输出
        pw.print(employees);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
