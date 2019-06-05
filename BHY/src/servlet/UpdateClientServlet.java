package servlet;

import entity.ClientCustom;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/UpdateClientServlet")
public class UpdateClientServlet extends HttpServlet {
    /**
     * 更新一条顾客信息
     * cl_id为检索信息，其他为更新信息
     * 更新成功返回true，否则返回false
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();

        //封装数据
        ClientCustom clientCustom = new ClientCustom();
        try {
            BeanUtils.populate(clientCustom, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用业务逻辑
        if(ClientService.updateClient(clientCustom)){
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
