//package textNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * ---------------------------------------------------------------------------------------------------------------------
 * 使用NIO完成网络通信的三个核心：
 * ····|- 通道（Channel）：负责连接通讯的两端
 * ····|- 缓冲区（Buffer）：负责数据存储
 * ····|- 选择器（Selector）：是SelectableChannel的多路复用器（？？？），
 * ················用于监控SelectableChannel的IO状况
 * ········|- SelectableChannel
 * ············|- SocketChannel
 * ············|- ServerSocketChannel
 * ············|- DatagramChannel
 * ---------------------------------------------------------------------------------------------------------------------
 * 这里使用阻塞式NIO网络通讯机型文件向服务端的提交
 * ---------------------------------------------------------------------------------------------------------------------
 * 阻塞式的网络通讯就是使用了ServerSocket和Socket类的Channel
 * 与之前的网络通讯不同，在数据传输完成之后需要调用Socket的shutDownOutput()方法
 * ---------------------------------------------------------------------------------------------------------------------
 * 还有一个问题
 * 我的本机的ip地址不知道为什么就变了，按道理这东西不会变的啊
 * ---------------------------------------------------------------------------------------------------------------------
 * author:Benjamin
 * date:2019.4.3
 * ---------------------------------------------------------------------------------------------------------------------
 */

public class TextBlockingNIO {
    public static void main(String[] args) {

    }
}

/**
 * 阻塞式客户端
 */
class client {
    public static void main(String[] args) {

        try (
                SocketChannel sc = SocketChannel.open(
                        new InetSocketAddress("192.168.1.109", 50000)
                );
                FileChannel fc = FileChannel.open(
                        Paths.get("约定.flac"),
                        StandardOpenOption.READ
                )
        ) {
            //发送数据
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (fc.read(buf) != -1) {
                buf.flip();
                sc.write(buf);
                buf.clear();
            }
            sc.shutdownOutput();    //表示发送完毕

            // 接收服务端的反馈
            int len;
            while ((len = sc.read(buf)) != -1) {
                buf.flip();
                System.out.println(new String(buf.array(), 0, len));
                buf.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 阻塞式服务端
 */
class Server {
    public static void main(String[] args) {
        try (
                ServerSocketChannel ssc = ServerSocketChannel.open();
                FileChannel fc = FileChannel.open(
                        Paths.get("约定(copyByServerSocket).flac"),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.CREATE
                )
        ) {
            ssc.bind(new InetSocketAddress(50000)); // 设置服务端的端口号
            SocketChannel sc = ssc.accept(); // 获取连接到服务端的客户端


            ByteBuffer buf = ByteBuffer.allocate(1024);

            while (sc.read(buf) != -1) {
                buf.flip();
                fc.write(buf);
                buf.clear();
            }

            buf.put("接收数据成功！".getBytes());
            buf.flip();
            sc.write(buf);

            // 手动关闭SocketChannel的话  并不需要进行阻塞状态的切换
            // 这里存在try-with自动关闭资源，所以需要手动告知客户端数据传输完毕
            sc.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
