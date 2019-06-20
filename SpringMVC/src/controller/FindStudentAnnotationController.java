package controller;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import po.Student;
import po.StudentQueryVo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
//@RequestMapping("/student")
public class FindStudentAnnotationController {
    @RequestMapping(value = "/findStudentAnnotationController.action", method = {RequestMethod.POST, RequestMethod.GET})
    //@RequestParam的value设置前端返回的数据中该参数的key，required表示该参数是否必须传入,defaultValue表示默认值
    public ModelAndView findStudentAnnotationController(
            @RequestParam(value = "name", required = false, defaultValue = "Benjamin") String studentName,
            @RequestParam(value = "date", required = false) Date date,
            StudentQueryVo studentQueryVo) {

        //自定义参数绑定的测试，绑定Date类型的数据
        if (date != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(simpleDateFormat.format(date));
        }

        //参数啊绑定pojo对象
        System.out.println(studentQueryVo);

        // 先不连接dao层，使用静态数据进行模拟
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            students.add(new Student(i, studentName, 19));
        }
        //填充ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相当于request的setAttribut方法
        modelAndView.addObject("students", students);
        //指定视图，也就是请求响应的地方，这里暂时只是用jsp，html+css+js的方式暂且不知道
        modelAndView.setViewName("JSP/FindStudent.jsp");
        return modelAndView;
    }
}
