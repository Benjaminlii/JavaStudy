package servlet;

import entity.CargoCustom;
import entity.CargoQueryVo;
import entity.User;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import service.CargoService;
import util.DateStringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/addCargoServlet")
public class addCargoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();

        //封装数据
        CargoQueryVo cargoQueryVo = new CargoQueryVo();
        CargoCustom cargoCustom = new CargoCustom();
        try {
            BeanUtils.populate(cargoCustom, request.getParameterMap());
            cargoCustom.setC_getDate(DateStringUtil.stringToDate(request.getParameter("c_getDate")));
            cargoCustom.setC_expirationDate(DateStringUtil.stringToDate(request.getParameter("c_expirationDate")));
            cargoCustom.setC_producedDate(DateStringUtil.stringToDate(request.getParameter("c_getDate")));
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        cargoQueryVo.setCargoCustom(cargoCustom);
        cargoQueryVo.setUser((User) request.getSession().getAttribute("user"));

        //调用业务逻辑
        if(CargoService.addCargo(cargoQueryVo)){
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
