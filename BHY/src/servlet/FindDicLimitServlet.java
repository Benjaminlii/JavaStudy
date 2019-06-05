package servlet;

import entity.DictionaryQueryVo;
import entity.Page;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import service.DictionaryService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FindDicLimitServlet")
public class FindDicLimitServlet extends HttpServlet {
    /**
     * 分页查询字典信息
     * 只需要填充分页信息 page = ?
     * 返回值：[
     *              {"d_name":"dog","d_par_id":19,"d_id":22,"d_value":"杂种狗"},
     *              {"d_name":"cat","d_par_id":20,"d_id":23,"d_value":"杂种猫"},
     *              {"d_name":"dog","d_par_id":19,"d_id":25,"d_value":"哈士奇"},
     *              {"d_name":"dog","d_par_id":19,"d_id":26,"d_value":"阿拉斯加"},
     *              {"d_name":"dog","d_par_id":19,"d_id":27,"d_value":"柯基"},
     *              {"d_name":"dog","d_par_id":19,"d_id":28,"d_value":"萨摩耶"},
     *              {"d_name":"dog","d_par_id":19,"d_id":29,"d_value":"泰迪"},
     *              {"d_name":"cat","d_par_id":20,"d_id":30,"d_value":"短毛猫"},
     *              {"d_name":"cat","d_par_id":20,"d_id":31,"d_value":"布偶猫"},
     *              {"d_name":"cat","d_par_id":20,"d_id":32,"d_value":"加菲猫"},
     *              {"d_name":"cat","d_par_id":20,"d_id":33,"d_value":"橘猫"},
     *              {"d_name":"medical","d_par_id":6,"d_id":34,"d_value":"医疗"},
     *              {"d_name":"clean","d_par_id":6,"d_id":35,"d_value":"清洁"},
     *              {"d_name":"medical","d_par_id":34,"d_id":36,"d_value":"疫苗注射"},
     *              {"d_name":"medical","d_par_id":34,"d_id":37,"d_value":"看病"},
     *              {"d_name":"medical","d_par_id":34,"d_id":38,"d_value":"体检"},
     *              {"d_name":"clean","d_par_id":35,"d_id":39,"d_value":"洗澡"},
     *              {"d_name":"clean","d_par_id":35,"d_id":40,"d_value":"剪指甲"},
     *              {"d_name":"EmplpyeeType","d_par_id":7,"d_id":41,"d_value":"店长"},
     *              {"d_name":"EmplpyeeType","d_par_id":7,"d_id":42,"d_value":"医师"}
     *        ]
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONArray dictionarys = null;

        //封装数据
        DictionaryQueryVo dictionaryQueryVo = new DictionaryQueryVo();
        String page = request.getParameter("page");
        if (!"".equals(page) && page != null) {
            dictionaryQueryVo.setPage(new Page(Integer.valueOf(page)));
        }

        //调用业务逻辑
        dictionarys = JSONArray.fromObject(DictionaryService.findDicLimit(dictionaryQueryVo));

        //输出
        pw.print(dictionarys);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
