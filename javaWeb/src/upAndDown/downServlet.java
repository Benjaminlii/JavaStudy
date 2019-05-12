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

        //���ص��ļ���
        String fileName = request.getParameter("filename");

        //�����ļ�������Ӧ��Ϣͷ
        response.setContentType(getServletContext().getMimeType(fileName));
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);

        //ͨ���ļ���ַ�����ļ�ת����������
        InputStream in = getServletContext().getResourceAsStream("/image/picture.jpg");

        //����Ӧ���õ������
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
