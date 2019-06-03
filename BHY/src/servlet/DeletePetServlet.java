package servlet;

import entity.PetCustom;
import entity.PetQueryVo;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import service.PetService;
import sun.misc.PerfCounter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/DeletePetServlet")
public class DeletePetServlet extends HttpServlet {
    /**
     * 删除一条宠物信息,宠物被连接的外键需要被清空（服务）
     * 参数：p_id
     * 删除成功返回rtn：1， 否则rtn：0
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();

        //封装数据
        PetCustom petCustom = new PetCustom();
        try {
            BeanUtils.populate(petCustom, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用业务逻辑
        if(PetService.deletePet(petCustom)){
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
