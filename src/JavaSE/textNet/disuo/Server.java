package JavaSE.textNet.disuo;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理服务端与多个客户端通信的问题
 * 使用多线程来解决
 * Server类处理消息的发送，接收
 * ServerAdd类用于建立多个连接，while（true）循环等待
 * ServerThread类为服务端连接的某一个客户端
 * 使用Map<String, Socket>连接各层
 *
 * author:Benjamin
 * date:2019.5.13
 */
public class Server {

    private Map<String, Socket> Sockets = new HashMap<>();

    public static void main(String[] args) {
        method();
    }
    public static void method(){

    }
}
