package servlet;

import entity.Dictionary;
import net.sf.json.JSONArray;
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

@WebServlet("/FindDicByParValueServlet")
public class FindDicByParValueServlet extends HttpServlet {
    /**
     * 根据父节点的value查找其子结点
     * 参数：查询信息，只需要填充d_value字段
     * 返回值：[
     *              {"d_name":"dog","d_par_id":19,"d_id":22,"d_value":"杂种狗"},
     *              {"d_name":"dog","d_par_id":19,"d_id":25,"d_value":"哈士奇"},
     *              {"d_name":"dog","d_par_id":19,"d_id":26,"d_value":"阿拉斯加"},
     *              {"d_name":"dog","d_par_id":19,"d_id":27,"d_value":"柯基"},
     *              {"d_name":"dog","d_par_id":19,"d_id":28,"d_value":"萨摩耶"},
     *              {"d_name":"dog","d_par_id":19,"d_id":29,"d_value":"泰迪"}
     *         ]
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONArray dictionarys = null;

        //封装数据
        Dictionary dictionary = new Dictionary();
        try {
            BeanUtils.populate(dictionary,request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用业务逻辑
        dictionarys = JSONArray.fromObject(DictionaryService.findDicByParValue(dictionary));

        //输出
        pw.print(dictionarys);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
