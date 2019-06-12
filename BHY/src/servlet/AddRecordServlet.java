package servlet;

import entity.RecordCustom;
import entity.RecordQueryVo;
import entity.User;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import service.RecordService;
import util.DateStringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@WebServlet("/AddRecordServlet")
public class AddRecordServlet extends HttpServlet {
    /**
     * 添加一条销售单信息，回返r_id
     * 必须包括顾客手机号码，登陆状态，c_id前端下拉菜单（或通过点击货物进入下单页面），当前时间，售出价格，购买数量
     * 插入成功返回rtn:1，否则返回rtn:0
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();

        //封装数据
        //注册转换器
        DateConverter dateConverter = new DateConverter();
        //设置日期格式
        dateConverter.setPatterns(new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"});
        //注册格式
        ConvertUtils.register(dateConverter, Date.class);

        RecordQueryVo recordQueryVo = new RecordQueryVo();
        RecordCustom recordCustom = new RecordCustom();
        try {
            BeanUtils.populate(recordQueryVo, request.getParameterMap());
            BeanUtils.populate(recordCustom, request.getParameterMap());
            recordCustom.setR_time(DateStringUtil.stringToDate(request.getParameter("r_time")));
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        recordQueryVo.setRecordCustom(recordCustom);
        recordQueryVo.setUser((User) request.getSession().getAttribute("user"));

        //调用业务逻辑
        if(RecordService.insertRecord(recordQueryVo)){
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
