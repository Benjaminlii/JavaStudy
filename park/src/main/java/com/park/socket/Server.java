package main.java.com.park.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import main.java.com.park.serviceImpl.SocketServiceImp;
import com.park.vo.SocketEntity;
import com.alibaba.fastjson.JSONObject;


/**
 * @author wangpei
 * @version 创建时间：2017年2月26日 下午7:33:55
 * 启动后台socket
 */
public class Server extends Thread {
    private Socket socket = null;

    public void run() {
        ServerSocket serverSocket = null;
        // while (true) {


        try {
            serverSocket = new ServerSocket(8089);
            while (true) {
                socket = serverSocket.accept();
                System.out.println("连接上啦");
                PrintStream ps = new PrintStream(socket.getOutputStream());
				/*
				while(true) {
					ps.println("1111111*");
				}
				*/
                //ps.close();
                //socket.close();
                new ServerThread(socket).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

// 开启线程类
class ServerThread extends Thread {
    private Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        String str = Translate.ReadText(socket);// 读取到传过来的值
        String type = null;
        // 对type进行处理
        Gson gson = new Gson();

        java.lang.reflect.Type types = new TypeToken<SocketEntity>() {
        }.getType();
        SocketEntity ps = gson.fromJson(str, types);
        //type = ps.getType();
        for (int i = 1; i < 3; i++) {
            type = String.valueOf(i);
            switch (type) {
                case "0": {// 总控程序请求的进程,响应总控并给其说明已接收到。{type:"0",message:"disuo,ok"}
                    SocketServiceImp.controller = socket;
                    Translate.Send(socket, "ok");// 发送ok
                    System.out.println("ok");

                }
                break;
                case "1": {// android端请求打开地锁,响应android端请求，并将socket发送给地锁总控。{type:"1",carspace_id:"a01",parking_id:"1"}
                    Translate.Send(SocketServiceImp.controller, str);// 给总控端发送请求
                    System.out.println("android发给总控" + str);
                    String result = Translate.ReadText(SocketServiceImp.controller);// 接收从总控端发送的请求
                    Translate.Send(socket, result);// 将总控的返回结果发送给android端
                    System.out.println("总控制的返回结果" + result);
                }
                break;
                case "2": {// android端请求关闭地锁,响应android端请求，并将socket发送给地锁总控。{type:"2",carspace_id:"a01",parking_id:"1"}
                    Translate.Send(SocketServiceImp.controller, str);// 给总控端发送请求
                    System.out.println(str);
                    String result = Translate.ReadText(SocketServiceImp.controller);// 接收从总控端发送的请求
                    Translate.Send(socket, result);// 将总控的返回结果发送给android端

                }
                break;

            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}

class Translate {
    public static Boolean Send(Socket csocket, String message) {
        try {
            PrintWriter out = new PrintWriter(new OutputStreamWriter(
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
     *
     * @param socket
     * @return
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
        if (count != 0) {
            System.out.println("count=" + count);
            byte[] bt = new byte[count];
            int readCount = 0;
            while (readCount < count) {
                try {
                    readCount += socket.getInputStream().read(bt, readCount,
                            count - readCount);
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
            System.out.println("readCount=" + readCount);

            s = new String(bt);
            System.out.println("s=" + s);

        }
        return s;
    }

}
