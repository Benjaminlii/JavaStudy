package upAndDown;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/downServlet")
public class downServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //下载的文件名
        String fileName = request.getParameter("filename");

        //下载文件设置响应消息头
        response.setContentType(getServletContext().getMimeType(fileName));
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);

        //通过文件地址，将文件转换成输入流
        InputStream in = getServletContext().getResourceAsStream("/image/picture.jpg");

        //从响应处得到输出流
        ServletOutputStream out = response.getOutputStream();
        byte[] bt = new byte[1024];
        int len;
        while ((len = in.read(bt)) != -1) {
            out.write(bt, 0, len);
        }
        out.close();
        in.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
