package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import po.Student;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FindStudentAnnotationController {
    @RequestMapping("/findStudentAnnotationController.action")
    public ModelAndView findStudentAnnotationController(){
        // 先不连接dao层，使用静态数据进行模拟
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= 10; i++){
            students.add(new Student(i, "Benjamin", 19));
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
