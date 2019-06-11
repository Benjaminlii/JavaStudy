package servlet;

import entity.Dictionary;
import entity.DictionaryCustom;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import service.DictionaryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/FindDValueByIDServlet")
public class FindDValueByIDServlet extends HttpServlet {
    /**
     * 通过字典id查询字典对象
     * 参数： 封装的对象，只需要填充d_id字段
     * 返回值 返回d_value
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();

        //封装数据
        DictionaryCustom dictionaryCustom = new DictionaryCustom();
        try {
            BeanUtils.populate(dictionaryCustom, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用业务逻辑
        Dictionary dictionary = DictionaryService.findDicByID(dictionaryCustom);
        jsonObject.put("d_value", dictionary.getD_value());

        //输出
        pw.print(jsonObject);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
