package servlet;

import com.mysql.cj.xdevapi.JsonArray;
import dao.DictionaryDao;
import dao.DictionaryDaoImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.PetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/FindAllPetServlet")
public class FindAllPetServlet extends HttpServlet {
    /**
     * 响应前台发来的查询所有宠物信息的请求
     * 无参数
     * 返回{pets:[{}, {}, {}], dics:[{}, {}, {}]}(返回一个json，其中pets对应宠物信息的json数组，dics对应字典数据json数组)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        JSONArray pets = null;
        JSONArray dics = null;

        //无参数
        //调用业务逻辑
        //得到全部pet
        pets = JSONArray.fromObject(PetService.findAllPet());
        //得到宠物类型的字典
        DictionaryDao dictionaryDao = new DictionaryDaoImpl();
        try {
            dics = JSONArray.fromObject(dictionaryDao.findAllDictionaryByParValue("宠物品种"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jsonObject.put("pets",pets);
        jsonObject.put("dics",dics);

        //输出
        pw.print(jsonObject);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
