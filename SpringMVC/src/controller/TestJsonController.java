package controller;

import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import po.Student;
import po.StudentQueryVo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestJsonController {
    /**
     * SpringMVC进行JSON数据交互的Demo
     * 接收一个JSON类型的StudentQueryVo对象
     * 控制台打印之后设置sname为Benjamin后返回JSON类型的该对象
     * url：/test/testJson
     *
     * @return 将姓名修改后传回去的JSON数据
     */
    @RequestMapping("/testJson")
    @ResponseBody
    public String testJson(@RequestBody List<A> list) {

        System.out.println(list.size());


        for (A key : list) {
            System.out.println(key);
        }
        return "success";
    }

}
class A implements Serializable {
    private String k1;
    private String k2;

    public String getK1() {
        return k1;
    }

    public void setK1(String k1) {
        this.k1 = k1;
    }

    public String getK2() {
        return k2;
    }

    public void setK2(String k2) {
        this.k2 = k2;
    }

    @Override
    public String toString() {
        return "A{" +
                "k1='" + k1 + '\'' +
                ", k2='" + k2 + '\'' +
                '}';
    }
}