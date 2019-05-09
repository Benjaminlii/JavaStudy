import java.io.FileWriter;
import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "ChangeOff", value = "/changeOff")
public class ChangeOff extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
        FileWriter fw = new FileWriter("disuo.json");
        fw.write("{\"servo\": \"rise\",\"light\": \"off\"}");
        fw.flush();
        fw.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
}
