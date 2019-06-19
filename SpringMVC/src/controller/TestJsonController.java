package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import po.Student;
import po.StudentQueryVo;

@Controller
@RequestMapping("/test")
public class TestJsonController {
    /**
     * SpringMVC进行JSON数据交互的Demo
     * 接收一个JSON类型的StudentQueryVo对象
     * 控制台打印之后设置sname为Benjamin后返回JSON类型的该对象
     * url：/test/testJson
     *
     * @param studentQueryVo 前端传入JSON类型的数据
     * @return 将姓名修改后传回去的JSON数据
     */
    @RequestMapping("/testJson")
    @ResponseBody
    public String testJson(@RequestBody Student student) {

     //   System.out.println(studentQueryVo);
        System.out.println(student);

        return "1";
//        studentQueryVo.getStudentCustom().setSname("Benjamin");
     //   studentQueryVo.setSname("111");
     //   return studentQueryVo;
    }

}
