package servlet;

import net.sf.json.JSONArray;
import service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FindClientLimitServlet")
public class FindClientLimitServlet extends HttpServlet {
    /**
     * 分页查询顾客信息，在没有开发顾客板块的情况下，u_id全部为3，前端不需要解析这一属性
     * 无参数
     * 返回由一条条顾客信息组成的JSONArray
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONArray jsonArray = null;

        //封装数据
        int page = Integer.valueOf(request.getParameter("page"));

        //调用业务逻辑
        jsonArray = JSONArray.fromObject(ClientService.findClientLimit(page));

        //输出
        pw.print(jsonArray);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
