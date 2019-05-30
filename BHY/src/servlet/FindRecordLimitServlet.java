package servlet;

import net.sf.json.JSONArray;
import service.RecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FindRecordLimitServlet")
public class FindRecordLimitServlet extends HttpServlet {
    /**
     * 分页查询销售记录的详细信息
     * 参数：页码page
     * 返回值：json数组
     * [{"c_id":1,"cl_id":1,"cl_name":"小刚","r_id":1,"r_name":"狗粮","r_num":1,"r_pattern":"","r_price":150,
     * "r_time":{"date":25,"day":6,"hours":2,"minutes":0,"month":4,"nanos":0,"seconds":0,"time":1558720800000,"timezoneOffset":-480,"year":119},
     * "s_id":1,"st_name":""}
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONArray records = null;

        //封装数据
        int page = Integer.valueOf(request.getParameter("page"));

        //调用业务逻辑
        records = JSONArray.fromObject(RecordService.findRecordLimit(page));

        //输出
        pw.print(records);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
