package servlet;

import entity.Page;
import entity.PetCustom;
import entity.PetQueryVo;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;
import service.PetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

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

        //封装信息
        PetQueryVo petQueryVo = new PetQueryVo();
        PetCustom petCustom = new PetCustom();
        try {
            BeanUtils.populate(petCustom, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        petQueryVo.setPetCustom(petCustom);
        String page = request.getParameter("page");
        if(!"".equals(page) && page != null) {
            petQueryVo.setPage(new Page(Integer.valueOf(page)));
        }
        //调用业务逻辑
        JSONArray pets = JSONArray.fromObject(PetService.findPetLimitInDetail(petQueryVo));

        //输出
        pw.print(pets);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
