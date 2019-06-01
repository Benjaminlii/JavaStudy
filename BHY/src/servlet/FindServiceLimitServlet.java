package servlet;

import entity.Page;
import entity.ServiceCustom;
import entity.ServiceQueryVo;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;
import service.ServiceService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/FindServiceLimitServlet")
public class FindServiceLimitServlet extends HttpServlet {
    /**
     * [分页][条件]查询服务项信息
     * 参数：查询条件和分页
     * 返回值：[
     *          {"d_id":37,"d_value":"看病","e_id":0,"e_name":"","p_id":1,"s_aTime":null,"s_id":1,"s_isDispose":"true","s_isFinish":"true","s_price":0},
     *          {"d_id":38,"d_value":"体检","e_id":0,"e_name":"","p_id":3,"s_aTime":null,"s_id":2,"s_isDispose":"false","s_isFinish":"false","s_price":0},
     *          {"d_id":38,"d_value":"体检","e_id":0,"e_name":"","p_id":4,"s_aTime":null,"s_id":3,"s_isDispose":"true","s_isFinish":"false","s_price":0}
     *         ]
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONArray services = null;

        //封装数据
        ServiceQueryVo serviceQueryVo = new ServiceQueryVo();
        ServiceCustom serviceCustom = new ServiceCustom();
        try {
            BeanUtils.populate(serviceCustom, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        serviceQueryVo.setServiceCustom(serviceCustom);
        String page = request.getParameter("page");
        if (!"".equals(page) && page != null) {
            serviceQueryVo.setPage(new Page(Integer.valueOf(page)));
        }

        //调用业务逻辑
        services = JSONArray.fromObject(ServiceService.findServiceLimitInDetail(serviceQueryVo));

        //输出
        pw.print(services);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
