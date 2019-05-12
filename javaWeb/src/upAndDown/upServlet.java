package upAndDown;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/upServlet")
public class upServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ������Ӧ��ʽ
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        //�ϴ�
        //���ж�multipart����
        if (ServletFileUpload.isMultipartContent(request)) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            //ͨ��parseRequest����form�е����������ֶΣ�������һ��List<FileItem>��
            List<FileItem> items = null;
            try {
                items = upload.parseRequest(request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            Iterator<FileItem> iter;
            iter = items != null ? items.iterator() : null;
            if (iter != null) {
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    String itemName = item.getFieldName(); //��ȡ��ͨ�ֶ���
                    int sno = -1;
                    String sname = null;
                    if(item.isFormField()) {// ��ͨ���ֶ�
                        if (itemName.equals("sno")) {
                            sno = Integer.valueOf(item.getString("utf-8"));
                        } else if (itemName.equals("utf-8")) {
                            sname = item.getString("utf-8");
                        } else{
                            System.out.println("�����ֶ�");
                        }
                    }else{//�ļ��ֶ�
                        String fileName = item.getName(); //�õ��ļ���
                        try {
                            //���ļ��ϴ���һ��·���£�����ʹ�ñ��ص�·��
                            //tomcat���������·��ÿ�����±�����Ŀ�ؽ������
                            item.write(new File("E:\\Benjamin\\0110", fileName));
                            System.out.println(fileName + "�ϴ��ɹ�");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
