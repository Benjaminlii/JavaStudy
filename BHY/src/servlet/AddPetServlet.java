package servlet;

import entity.*;
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

@WebServlet("/AddPetServlet")
public class AddPetServlet extends HttpServlet {
    /**
     * 添加一条宠物信息
     * 参数： 宠物品种 d_id，顾客手机号 mobile，宠物店id s_id(不需要提供，后台根据登陆用户查询)[，年龄 p_age，性别 p_sex，体重 p_height]
     * 返回值：添加成功返回rtn：1，否则返回rtn：0
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        boolean rtn = false;
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();

        //封装数据 这里的client应该包含mobile手机号，pet应该包含品种d_id
        Client client = new Client();
        PetQueryVo petQueryVo = new PetQueryVo();
        PetCustom petCustom = new PetCustom();
        try {
            BeanUtils.populate(client, request.getParameterMap());
            BeanUtils.populate(petCustom, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        petQueryVo.setClient(client);
        petQueryVo.setPetCustom(petCustom);
        petQueryVo.setUser((User) request.getSession().getAttribute("user"));

        //调用业务逻辑
        rtn = PetService.addPet(petQueryVo);
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
