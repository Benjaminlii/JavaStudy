package addStudent.servlet;

import addStudent.entity.Student;
import addStudent.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddStudentServlet", value = "/addStudent")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //��������Ľ�����ʽΪutf-8
        request.setCharacterEncoding("utf-8");
        //���������������Ӧ�ı����ʽΪutf-8
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        //�������е����ݷ�װΪStudent����
        Student stu = new Student(
                Integer.valueOf(request.getParameter("sno"))
                , String.valueOf(request.getParameter("sname"))
                , Integer.valueOf(request.getParameter("sage"))
                , String.valueOf(request.getParameter("saddress"))
        );
        String rtn = null;
        if(StudentService.addStudent(stu)){
            rtn = "����ɹ���";
        }else{
            rtn = "����ʧ�ܣ�";
        }
        //��ǰ�˷�����������
        response.getWriter().print(rtn);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
