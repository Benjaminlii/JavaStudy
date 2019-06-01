package servlet;

import entity.Page;
import entity.RecordCustom;
import entity.RecordQueryVo;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;
import service.RecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/FindRecordLimitServlet")
public class FindRecordLimitServlet extends HttpServlet {
    /**
     * [分页][条件]查询销售记录的详细信息
     * 参数：查询条件和分页条件
     * 返回值：[
     *              {"c_id":1,"c_name":"狗粮","cl_id":1,"cl_name":"小刚","r_id":1,"r_num":1,"r_pattern":"","r_price":150,"r_time":
     *                         {"date":25,"day":6,"hours":2,"minutes":0,"month":4,"seconds":0,"time":1558720800000,"timezoneOffset":-480,"year":119},"st_address":"","st_id":1},
     *              {"c_id":1,"c_name":"狗粮","cl_id":1,"cl_name":"小刚","r_id":3,"r_num":1,"r_pattern":"","r_price":150,"r_time":
     *                         {"date":5,"day":0,"hours":22,"minutes":0,"month":4,"seconds":0,"time":1557064800000,"timezoneOffset":-480,"year":119},"st_address":"","st_id":1},
     *              {"c_id":3,"c_name":"疫苗","cl_id":2,"cl_name":"小强","r_id":2,"r_num":1,"r_pattern":"","r_price":300,"r_time":
     *                         {"date":25,"day":6,"hours":1,"minutes":0,"month":4,"seconds":0,"time":1558717200000,"timezoneOffset":-480,"year":119},"st_address":"","st_id":3}
     *         ]
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONArray records = null;

        //封装数据
        RecordQueryVo recordQueryVo = new RecordQueryVo();
        RecordCustom recordCustom = new RecordCustom();
        try {
            BeanUtils.populate(recordCustom, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        recordQueryVo.setRecordCustom(recordCustom);
        String page = request.getParameter("page");
        if(!"".equals(page)&&page!=null){
            recordQueryVo.setPage(new Page(Integer.valueOf(page)));
        }

        //调用业务逻辑
        records = JSONArray.fromObject(RecordService.findRecordLimitInDetail(recordQueryVo));

        //输出
        pw.print(records);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
