package servlet;

import entity.ServiceCustom;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import service.ServiceService;
import util.DateStringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/AddServiceServlet")
public class AddServiceServlet extends HttpServlet {
    /**
     * 插入一条服务项信息
     * 插入的服务信息必须要提供宠物id， 字典id（服务类型）， 员工id
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
        ServiceCustom serviceCustom = new ServiceCustom();
        try {
            BeanUtils.populate(serviceCustom, request.getParameterMap());
            serviceCustom.setS_atime(DateStringUtil.stringToDate(request.getParameter("s_atime")));
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用业务逻辑
        if(ServiceService.insertService(serviceCustom)){
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
