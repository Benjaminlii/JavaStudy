package servlet;

import entity.ClientCustom;
import entity.ClientQueryVo;
import entity.Page;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;
import service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/FindClientLimitServlet")
public class FindClientLimitServlet extends HttpServlet {
    /**
     * [分页][条件]查询顾客信息
     * 参数：顾客信息和页码
     * 返回值：[
     *          {"cl_age":0,"cl_emil":"","cl_id":1,"cl_name":"小刚","cl_sex":"","mobile":"13712341234","u_id":4},
     *          {"cl_age":0,"cl_emil":"","cl_id":2,"cl_name":"小强","cl_sex":"","mobile":"13956785678","u_id":5}
     *         ]
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONArray Clients = null;

        //封装数据
        String page = request.getParameter("page");
        ClientQueryVo clientQueryVo = new ClientQueryVo();
        ClientCustom clientCustom = new ClientCustom();
        try {
            BeanUtils.populate(clientCustom, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        clientQueryVo.setClientCustom(clientCustom);
        if(!"".equals(page) && page != null) {
            clientQueryVo.setPage(new Page(Integer.valueOf(page)));
        }
        //调用业务逻辑
        Clients = JSONArray.fromObject(ClientService.findClientLimitInDetail(clientQueryVo));

        //输出
        pw.print(Clients);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
