package studentDemo.servlet;

import studentDemo.entity.Student;
import studentDemo.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addStudentServlet")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求的解析格式为utf-8
        request.setCharacterEncoding("utf-8");
        //设置浏览器解析响应的编码格式为utf-8
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        //将请求中的数据封装为Student对象
        Student stu = new Student(
                Integer.valueOf(request.getParameter("sno"))
                , String.valueOf(request.getParameter("sname"))
                , Integer.valueOf(request.getParameter("sage"))
                , String.valueOf(request.getParameter("saddress"))
        );
        if(StudentService.addStudent(stu)){
            request.setAttribute("add", "1");
        }else{
            request.setAttribute("add", "0");
        }
        request.getRequestDispatcher("/findAllStudentServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
