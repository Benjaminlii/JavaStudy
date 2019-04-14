package textNIO;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * ---------------------------------------------------------------------------------------------------------------------
 * 使用非阻塞式NIO网络通讯向服务端发送数据
 * 这里相当于服务端一直在线，客户端可以任意的进行连接和数据传输，并且服务端会同时处理这些数据
 * 也有并发的意思
 * ---------------------------------------------------------------------------------------------------------------------
 * 加入了选择器（Selector）
 * ---------------------------------------------------------------------------------------------------------------------
 * 客户端没有什么大的变化，只是将套接字通道的状态改为非阻塞式，其他与非阻塞式无二。
 * 服务端差别非常大：
 * ····首先，需要得到选择器，并将服务端注册到选择器中，并选择服务端的监听属性为接收
 * ····然后使用select()方法进行监听，选择器监听到一个Channel属于就绪状态时
 * ····就会将当前就绪的Channel的选择键添加入集合中，并返回数量
 * ····进入循环后，使用迭代器得到所有的选择键并进行遍历
 * ····判断选择键的属性，进行相应的操作
 * ········按照逻辑，这里先进行接收就绪Channel的判断
 * ········找出接受就绪的Channel（其实就是服务端的ServerSocketChannel）
 * ········找出连接到服务端的客户端额SocketChannel，并将其的状态也改成非阻塞式
 * ········并注册到选择器中，进行监听
 * ········当监听带读取就绪时，就可以得到所有的Channel，并进行数据的传输了
 * ---------------------------------------------------------------------------------------------------------------------
 * SelectableChannel.configureBlocking(boolean)：切换当前的阻塞属性
 *
 * Selector Selector.open()：得到，并且返回选择器
 *
 * SelectableChannel.register(Selector,SelectionKey)：将当前的SelectableChannel注册到传入的选择器中，并注明监听的属性
 *
 * int select()	：监控所有注册的Channel，
 * ····当它们中间有需要处理的IO 操作时，该方法返回，
 * ····并将对应得的SelectionKey 加入被选择的SelectionKey 集合中，该方法返回这些Channel 的数量。
 *
 * selector.selectedKeys()：得到选择器中的所有选择键
 * ---------------------------------------------------------------------------------------------------------------------
 * author:Benjamin
 * date:2019.4.4
 * ---------------------------------------------------------------------------------------------------------------------
 */

public class TextNonBlockingNIO {
    public static void main(String[] args) {

    }
}

/**
 * 非阻塞式NIO网络通讯的客户端
 */
class client{
    public static void main(String[] args) throws IOException {
        InetAddress ip = InetAddress.getLocalHost();
        //获取通道
        SocketChannel sChannel = SocketChannel.open(
                new InetSocketAddress(ip.getHostAddress(),10001));
        //切换阻塞模式
        sChannel.configureBlocking(false);
        //缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //发送数据
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            buf.put((new Date().toString() + "  " + InetAddress.getLocalHost().getHostAddress() + "\n" + in.nextLine()).getBytes());
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }
        //关闭流
        sChannel.close();
    }
}

/**
 * 服务端
 */
class server{
    public static void main(String[] args) throws IOException {
        //通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //切换非阻塞模式
        ssChannel.configureBlocking(false);
        //获取与服务端连接的客户端
        ssChannel.bind(new InetSocketAddress(10001));
        //获取选择器并绑定
        Selector selector = Selector.open();
        ssChannel.register(selector, SelectionKey.OP_ACCEPT); //服务器负责接收数据，所以监听“接收事件”
        //轮询式获取选择器上就绪的事件,Selector.select()方法监听所有注册的Channel
        // 当其中有一个需要进行IO操作时
        // 将该Channel注册的SelectionKey加入到SelectionKey集合中，并返回数量。
        while(selector.select() > 0){
            // 使用迭代器进行遍历
            Iterator<SelectionKey> sks = selector.selectedKeys().iterator();
            while(sks.hasNext()){
                //得到监听到的选择键
                SelectionKey sk = sks.next();
                //判断是哪一种监听到的事件，本例中只有接收和读取事件
                if(sk.isAcceptable()){
                    //获取接收就绪状态的服务端所连接的客户端
                    //设置为非阻塞模式
                    //注册到选择器中
                    SocketChannel sChannel = ssChannel.accept();
                    sChannel.configureBlocking(false);
                    sChannel.register(selector,SelectionKey.OP_READ);
                }else if(sk.isReadable()){
                    //有读取状态就绪，那么获得所有的通道，进行数据传输
                    //获取选择器中读就绪的通道,这是，sk是读取模式的选择键
                    SocketChannel sc = (SocketChannel)sk.channel();
                    //准备缓冲区，以及数据的接收
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while((len = sc.read(buf)) > 0){
                        buf.flip();
                        System.out.println(new String(buf.array(),0,len));
                        buf.clear();
                    }
                }
                sks.remove();
            }
        }
    }
}
