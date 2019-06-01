package servlet;

import entity.Page;
import entity.StoreCustom;
import entity.StoreQueryVo;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;
import service.StoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/FindStoreLimitServlet")
public class FindStoreLimitServlet extends HttpServlet {
    /**
     * [分页][条件]查找宠物店信息
     * 参数：查询条件和分页信息
     * 返回值：[
     *              {"d_id":16,"d_value":"总店","e_id":0,"e_name":"","s_address":"","st_id":1,"st_time":null},
     *              {"d_id":17,"d_value":"省店","e_id":0,"e_name":"","s_address":"","st_id":2,"st_time":null},
     *              {"d_id":18,"d_value":"市店","e_id":0,"e_name":"","s_address":"","st_id":3,"st_time":null}
     *         ]
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONArray stores = null;

        //封装数据
        StoreQueryVo storeQueryVo = new StoreQueryVo();
        StoreCustom storeCustom = new StoreCustom();
        try {
            BeanUtils.populate(storeCustom, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        storeQueryVo.setStoreCustom(storeCustom);
        String page = request.getParameter("page");
        if (!"".equals(page) && page != null) {
            storeQueryVo.setPage(new Page(Integer.valueOf(page)));
        }

        //调用业务逻辑
        stores = JSONArray.fromObject(StoreService.findStoreLimitInDetail(storeQueryVo));

        //输出
        pw.print(stores);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
