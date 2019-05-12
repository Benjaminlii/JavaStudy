package JavaSE.textNet;//package JavaSE.textNet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP传输方式需要进行客户端与服务端的实时连接
 * Socket为客户端
 * ServerSocket为服务端
 * 本程序在两个终端中运行，需要将包名注释掉，我也不知道为啥
 *
 * 客户端从键盘读入字母，由out流发送到服务端
 * 服务端通过in接受客户端发送的信息，将其转为大写再发送回去
 * 客户端接受到服务端返回的信息之后打印在控制台
 * <p>
 * author:Benjamin
 * date:2019.3.30
 */
public class TextTCP {
    public static void main(String[] args) throws IOException {
        // 服务端需要监听一个端口
        ServerSocket ss = new ServerSocket(8989);
        // 获取与服务端连接的客户端对象
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostName() + ".....已连接服务端。");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = new PrintStream(s.getOutputStream(), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.equals("bye"))
                break;
            out.println(line);
            line = br.readLine();
            System.out.println(line);
        }
        s.close();
        ss.close();
    }
    public static void main1(String[] args) throws IOException {
        // 服务端需要监听一个端口
        ServerSocket ss = new ServerSocket(8889);
        // 获取与服务端连接的客户端对象
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostName() + ".....已连接服务端。");
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        s.close();
        ss.close();
    }
}

/**
 * 客户端程序
 */
class TcpClient {
    public static void main1(String[] args) throws IOException {
        // Socket对象连接服务端时需要提供客户端的IP地址和端口号
        Socket s = new Socket("192.168.1.172", 10001);

        // 客户端和服务端之间通讯不需要发送数据，需要依靠客户端与服务端的io流
        // 客户端需要三个流，分别是两个Socket之间通讯的io流和一个从键盘读入文字的System.out
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = new PrintStream(s.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String line;
        while ((line = br.readLine()) != null) {
            out.println(line);
            System.out.println("server :" + in.readLine());
            if (line.equals("bye"))
                break;
        }

        s.close();
    }

}

/**
 * 服务端程序
 */
class TcpServer {
    public static void main(String[] args) throws IOException {
        // 服务端需要监听一个端口
        ServerSocket ss = new ServerSocket(10001);

        // 获取与服务端连接的客户端对象
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostName() + ".....已连接服务端。");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintStream out = new PrintStream(s.getOutputStream(), true);

        String line;

        while ((line = in.readLine()) != null) {
            System.out.println(line);
            if (line.equals("bye"))
                break;
            out.println(line.toUpperCase());
        }

        s.close();
        ss.close();
    }
}
