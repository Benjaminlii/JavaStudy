package servlet;

import net.sf.json.JSONArray;
import service.ServiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FindServiceLimitServlet")
public class FindServiceLimitServlet extends HttpServlet {
    /**
     * 分页查询服务项详细信息
     * 参数：页码page
     * 返回值：json数组
     * [{"d_id":37,"e_id":0,"e_name":"","p_id":1,"s_aTime":null,"s_id":1,
     * "s_isDispose":"true","s_isFinish":"true","s_price":0,"s_type":"看病"}]
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONArray services = null;

        //封装数据
        int page = Integer.valueOf(request.getParameter("page"));

        //调用业务逻辑
        services = JSONArray.fromObject(ServiceService.findServiceLimitInDetail(page));

        //输出
        pw.print(services);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
