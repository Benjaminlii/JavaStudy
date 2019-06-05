package servlet;

import entity.EmployeeCustom;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
    /**
     * 更新员工信息
     * 参数：包装更新信息，e_id为检索信息，其他为更新信息
     *      可以更新的信息：姓名e_name，工资e_salary，所属宠物店st_id，职务d_id，年龄e_age
     * 更新成功返回rtn:1，否则返回rtn:0
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();

        //封装数据
        //注册转换器
        DateConverter dateConverter = new DateConverter();
        //设置日期格式
        dateConverter.setPatterns(new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"});
        //注册格式
        ConvertUtils.register(dateConverter, Date.class);

        EmployeeCustom employeeCustom = new EmployeeCustom();
        try {
            BeanUtils.populate(employeeCustom,request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


        //调用业务逻辑
        if(EmployeeService.updateEmployee(employeeCustom)){
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
