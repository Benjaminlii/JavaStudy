package play.testSocket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    private Socket socket = null;

    public void run() {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(8989);
            while (true) {
                socket = serverSocket.accept();
                System.out.println("设备已连接");
//                PrintStream ps = new PrintStream(socket.getOutputStream());
                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerThread extends Thread {
    private Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {

    }
}

class Translate {
    /**
     * 向某个连接发送字符串数据
     */
    public static Boolean Send(Socket csocket, String message) {
        try {
            PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(
                    csocket.getOutputStream()), true);
            out.println(message);
            return true;
        } catch (Exception se) {
            se.printStackTrace();
            return false;
        }
    }

    /**
     * 读取数据，返回字符串类型
     */
    public static String ReadText(Socket socket) {
        int count = 0;
        String s = null;
        while (count == 0) {
            try {
                count = socket.getInputStream().available();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("count=" + count);
        byte[] bt = new byte[count];
        int readCount = 0;
        while (readCount < count) {
            try {
                readCount += socket.getInputStream().read(bt, readCount, count - readCount);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//            System.out.println("readCount=" + readCount);
        s = new String(bt);
        System.out.println("s=" + s);
        return s;
    }

}
