package servlet;

import entity.CargoCustom;
import entity.CargoQueryVo;
import entity.Page;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;
import service.CargoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/FindCargoLimitServlet")
public class FindCargoLimitServlet extends HttpServlet {
    /**
     * 分页查询货物的详细信息
     * 参数：页码page
     * 返回值：json数组
     * [{"c_expirationDate":null,"c_getDate":null,"c_id":1,"c_name":"狗粮","c_num":200,
     * "c_producedDate":null,"c_type":"饲料","d_id":13,"s_id":1,"st_name":""}]
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONArray cargos = null;

        //封装数据
        CargoQueryVo cargoQueryVo = new CargoQueryVo();
        CargoCustom cargoCustom = new CargoCustom();
        try {
            BeanUtils.populate(cargoCustom,request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        cargoQueryVo.setCargoCustom(cargoCustom);
        String page = request.getParameter("page");
        if(!"".equals(page) && page != null){
            cargoQueryVo.setPage(new Page(Integer.valueOf(page)));
        }

        //调用业务逻辑
        cargos = JSONArray.fromObject(CargoService.findCargoLimitInDetail(cargoQueryVo));

        //输出
        pw.print(cargos);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
