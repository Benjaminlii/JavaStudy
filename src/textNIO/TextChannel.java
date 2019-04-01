package textNIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.channels.FileChannel.*;

/**
 * ------------------------------------------------------------------------------------------
 * Channel（通道）：连接源和目标，Java NIO中负责缓冲区中数据的传输。
 * ------------------------------------------------------------------------------------------
 * 通道的主要实现类：
 * java.nio.channels.Channel接口
 * ····|- FileChannel
 * ····|- SocketChannel
 * ····|- ServerSocketChannel
 * ····|- DatagramChannel
 * ------------------------------------------------------------------------------------------
 * 获取通道：
 * 1、Java中对一些IO流中的类提供了getChannel()方法
 * ····|- 本地IO：
 * ········|- FileInputStream和FileOutputStream
 * ····|- 网络IO：
 * ········|- Socket
 * ········|- ServerSocket
 * 2、JDK1.7之后，NIO.2对各个通道都提供了静态方法open()
 * ····|- eg:FileChannel.open(paths.get("sec\\1.png"), StanderOpenOption.READ);
 * 3、JDK1.7之后，NIO.2中的Files工具类也提供了newByteChannel()方法
 * ------------------------------------------------------------------------------------------
 * <p>
 * ------------------------------------------------------------------------------------------
 * <p>
 * ------------------------------------------------------------------------------------------
 * <p>
 * ------------------------------------------------------------------------------------------
 * <p>
 * ------------------------------------------------------------------------------------------
 * author:Benjamin
 * date:2019.4.1
 * ------------------------------------------------------------------------------------------
 */

public class TextChannel {

    public static void main(String[] args) {
        m2();
    }

    /**
     * 通过IO流中的getChannel()方法获得Channel
     */
    private static void m1() {
        try (
                FileInputStream fis = new FileInputStream("src\\textNIO\\约定.flac");
                FileOutputStream fos = new FileOutputStream("src\\textNIO\\约定(copyByChannel1).flac");
                FileChannel inC = fis.getChannel();
                FileChannel outC = fos.getChannel()
        ) {
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (inC.read(buf) != -1) {
                // 循环使用读取通道进行源文件的读取
                // 每次读取判断是否读到数据
                // 每次读取完之后，将缓冲区转换为读取模式
                // 使用写入通道进行目标文件的写入
                // 每次使用完缓冲区之后进行缓冲区的清理重置
                buf.flip();
                outC.write(buf);
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过通道类的open()方法进行通道的获取
     */
    public static void m2() {
        try (
                FileChannel inC = FileChannel.open(
                        Paths.get("src\\textNIO\\约定.flac"),
                        StandardOpenOption.READ);   // 通道所接通的流的类型
                FileChannel outC = FileChannel.open(
                        Paths.get("src\\textNIO\\约定(copyByChannel2).flac"),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.CREATE) //CREATE如果文件存在，覆盖；CREATE_NEW如果文件存在，报错

        ) {
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while(inC.read(buf)!=-1){
                buf.flip();
                outC.write(buf);
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
