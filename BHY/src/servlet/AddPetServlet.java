package servlet;

import dao.ClientDao;
import dao.ClientDaoImpl;
import entity.Client;
import entity.Pet;
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
import java.sql.SQLException;

@WebServlet("/AddPetServlet")
public class AddPetServlet extends HttpServlet {
    /**
     * 添加一条宠物信息
     * 参数： 宠物品种 d_id，顾客手机号 mobile，[宠物店id s_id，年龄 p_age，性别 p_sex，体重 p_height]
     * 返回值：添加成功返回rtn：1，用户不存在返回rtn：2，数据库底层错误返回rtn：3
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        boolean rtn = false;
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();

        //封装数据 这里的client应该包含mobile手机号，pet应该包含品种id
        //这里先根据mobile查找client，然后填充pet的信息
        //当client未找到的时候，写入rtn：2
        ClientDao clientDao = new ClientDaoImpl();
        Client client = null;
        Pet pet = new Pet();
        try {
            client = clientDao.findClientByMobile(request.getParameter("mobile"));
            BeanUtils.populate(pet, request.getParameterMap());
        } catch (SQLException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        if(client==null) {
            //用户不存在
            jsonObject.put("rtn", 2);
        }else {
            pet.setCl_id(client.getCl_id());

            //调用业务逻辑
            if (PetService.addPet(pet, client)) {
                jsonObject.put("rtn", 1);
            } else {
                //底层出现错误
                jsonObject.put("rtn", 3);
            }
        }
        //输出
        pw.print(jsonObject);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
