import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.FileWriter;
import java.io.IOException;

@WebServlet(name = "ChangeOn", value = "/changeOn")
public class ChangeOn extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
        FileWriter fw = new FileWriter("disou.json");
        fw.write("{\"servo\": \"rise\",\"light\": \"on\"}");
        fw.flush();
        fw.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
}
