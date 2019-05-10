package studentDemo.servlet;

import studentDemo.entity.Student;
import studentDemo.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateStudentServlet")
public class updateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        Student stu = new Student(Integer.valueOf(request.getParameter("sno"))
                , request.getParameter("sname")
                , Integer.valueOf(request.getParameter("sage"))
                , request.getParameter("saddress")
        );
        if(StudentService.updateStudent(stu.getSno(), stu)){
            request.setAttribute("update", "1");
        }else{
            request.setAttribute("update", "0");
        }
        request.getRequestDispatcher("/findAllStudentServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
