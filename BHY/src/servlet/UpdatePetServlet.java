package servlet;

import entity.PetCustom;
import net.sf.json.JSONObject;
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

@WebServlet("/UpdatePetServlet")
public class UpdatePetServlet extends HttpServlet {
    /**
     * 更新一条宠物信息
     * p_id为检索信息，其他为更新信息，包括st_id， p_age， p_sex， p_height， p_healthy， cl_id
     * 更新成功返回rtn：1， 失败返回rtn：0
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        boolean rtn = false;

        //封装数据
        PetCustom petCustom = new PetCustom();
        try {
            BeanUtils.populate(petCustom, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用业务逻辑
        rtn = PetService.updatePet(petCustom);
        if(rtn){
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
