package studentDemo.servlet;

import studentDemo.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteStudentServlet")
public class deleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //若成功删除，则添加属性error为1，否则为0；未从此处跳转到show页面则没有error属性
        if(StudentService.deleteStudent(Integer.valueOf(request.getParameter("sno")))){
            request.setAttribute("delete", "1");
        }else{
            request.setAttribute("delete", "0");
        }
        request.getRequestDispatcher("/findAllStudentServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
