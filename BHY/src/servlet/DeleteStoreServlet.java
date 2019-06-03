package servlet;

import entity.StoreCustom;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import service.StoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@WebServlet("/DeleteStoreServlet")
public class DeleteStoreServlet extends HttpServlet {
    /**
     * 删除一条宠物店信息
     * 要进行删除的宠物店的信息，其中st_id必须被填充,并且st_id字段不能被其他表的外键关联
     * 删除成功返回rtn:1，否则返回rtn:0
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

        StoreCustom storeCustom = new StoreCustom();
        try {
            BeanUtils.populate(storeCustom, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用业务逻辑
        if(StoreService.deleteStore(storeCustom)){
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
