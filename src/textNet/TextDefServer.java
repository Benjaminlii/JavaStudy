//package textNet;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 自定义客户端
 * 由浏览器访问
 * 本机IP地址：DESKTOP-9HKOBH3/192.168.1.172
 *
 * 访问不到。。。
 * 该站点不安全
 *
 * author:Benjamin
 * date:2019.3.30
 */

public class TextDefServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10002);

        Socket s = ss.accept();

        System.out.println(s.getInetAddress().getHostAddress());

        PrintStream out = new PrintStream(s.getOutputStream(),true);

        out.println("已连接至客户端");

        s.close();

        ss.close();
    }
}
