package servlet;

import net.sf.json.JSONArray;
import service.PetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FindPetLimitServlet")
public class FindPetLimitServlet extends HttpServlet {
    /**
     * 响应前台发来的分页查询宠物信息的请求
     * 参数查寻的页码
     * 返回{"cl_id":0,"cl_name":"小刚","d_id":0,"p_age":0,"p_healthy":"","p_height":0,"p_id":1,"p_sex":"","p_type":"短毛猫","s_id":0,"st_name":""}
     * 返回一个json，其中各个字段对应pet的详细信息
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();

        //参数
        int page = Integer.valueOf(request.getParameter("page"));
        //调用业务逻辑
        JSONArray pets = JSONArray.fromObject(PetService.findPetLimit(page));

        //得到宠物店信息

        //输出
        pw.print(pets);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
