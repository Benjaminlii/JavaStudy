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
        // 设置响应格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        //上传
        //先判断multipart属性
        if (ServletFileUpload.isMultipartContent(request)) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            //通过parseRequest解析form中的所有请求字段，保存在一个List<FileItem>中
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
                    String itemName = item.getFieldName(); //获取普通字段名
                    int sno = -1;
                    String sname = null;
                    if(item.isFormField()) {// 普通表单字段
                        if (itemName.equals("sno")) {
                            sno = Integer.valueOf(item.getString("utf-8"));
                        } else if (itemName.equals("utf-8")) {
                            sname = item.getString("utf-8");
                        } else{
                            System.out.println("其他字段");
                        }
                    }else{//文件字段
                        String fileName = item.getName(); //得到文件名
                        try {
                            //将文件上传到一定路径下，建议使用本地的路径
                            //tomcat服务器里的路径每次重新编译项目回进行清空
                            item.write(new File("E:\\Benjamin\\0110", fileName));
                            System.out.println(fileName + "上传成功");
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
