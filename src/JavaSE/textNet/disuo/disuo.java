package JavaSE.textNet.disuo;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class disuo {
    @Test
    public void main1() throws IOException {
        // Socket对象连接服务端时需要提供客户端的IP地址和端口号
        Socket s = new Socket("192.168.1.126", 8089);
        System.out.println("客户端已连接！");

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintStream out = new PrintStream(s.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String line;
//        while ((line = br.readLine()) != null) {
        while (true) {
//            out.println(line);
            System.out.println("server :" + in.readLine());
//            if (line.equals("bye"))
//                break;
        }

//        s.close();
    }

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8089);
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostName() + ".....已连接服务端。");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = new PrintStream(s.getOutputStream(), true);
        String line;
        while ((line = in.readLine()) != null) {
            if (line.equals("bye"))
                break;
            out.println(line);
        }
        s.close();
        ss.close();
    }
}
