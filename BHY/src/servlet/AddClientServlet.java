package servlet;

import entity.Client;
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

@WebServlet("/AddClientServlet")
public class AddClientServlet extends HttpServlet {
    /**
     * 增加顾客信息的servlet
     * 需要从前端获得的信息：姓名，手机[，年龄，性别，emil]
     * 手机号唯一
     * <p>
     * 若添加成功，返回{rtn:"1"}
     * 若添加失败，返回{rtn:"0"}（手机号重复）
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();

        //封装信息
        Client client = new Client();
        try {
            BeanUtils.populate(client, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用逻辑层
        if(ClientService.addClient(client)){
            jsonObject.put("rtn", 1);
        }else{
            jsonObject.put("rtn", 0);
        }
        pw.print(jsonObject);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
