package servlet;

import net.sf.json.JSONArray;
import service.StoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FindStoreLimitServlet")
public class FindStoreLimitServlet extends HttpServlet {
    /**
     * 分页查找宠物店信息
     * 参数：页码page
     * 返回一个json，stores的值是封装了全部宠物店详细信息的json数组
     * [{"d_id":0,"e_id":0,"e_name":"","s_address":"","st_grade":"总店","st_id":1,"st_time":null}]
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONArray stores = null;

        //封装数据
        int page = Integer.valueOf(request.getParameter("page"));

        //调用业务逻辑
        //得到所有宠物店信息
        stores = JSONArray.fromObject(StoreService.findStoreLimit(page));

        //输出
        pw.print(stores);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
