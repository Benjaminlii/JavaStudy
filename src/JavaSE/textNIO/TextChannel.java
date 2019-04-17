package JavaSE.textNIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
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
 * 通道之间的数据传输：
 * ····|- transferFrom()
 * ····|- transferTo()
 * ------------------------------------------------------------------------------------------
 * 分散(Scatter)和聚集(Gather)
 * ····|-分散读取(Scattering Reads)：将通道中的苏话剧分散到多个缓冲区中
 * ····|-聚集写入(Gathering Writes)：将多个缓冲区中的数据聚集到通道中
 * ------------------------------------------------------------------------------------------
 * 字符集：Charset
 * ·····|- 编码器 Encoder
 * ·····|- 解码器 Decoder
 * ------------------------------------------------------------------------------------------
 * <p>
 * ------------------------------------------------------------------------------------------
 * author:Benjamin
 * date:2019.4.1
 * ------------------------------------------------------------------------------------------
 */

public class TextChannel {

    public static void main(String[] args) throws CharacterCodingException {
        m6();
    }

    /**
     * 通过IO流中的getChannel()方法获得Channel
     */
    private static void m1() {
        long start = System.currentTimeMillis();
        try (
                FileInputStream fis = new FileInputStream("src\\JavaSE.textNIO\\约定.flac");
                FileOutputStream fos = new FileOutputStream("src\\JavaSE.textNIO\\约定(copyByChannel1).flac");
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
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "mm");
    }

    /**
     * 通过通道类的open()方法进行通道的获取
     */
    private static void m2() {
        long start = System.currentTimeMillis();
        try (
                FileChannel inC = FileChannel.open(
                        Paths.get("src\\JavaSE.textNIO\\约定.flac"),
                        StandardOpenOption.READ     // 通道所接通的流的类型
                );
                FileChannel outC = FileChannel.open(
                        Paths.get("src\\JavaSE.textNIO\\约定(copyByChannel2).flac"),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.CREATE   //CREATE如果文件存在，覆盖；CREATE_NEW如果文件存在，报错
                )

        ) {
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (inC.read(buf) != -1) {
                buf.flip();
                outC.write(buf);
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "mm");
    }

    /**
     * 将通道直接建立在内存映射文件（缓冲）中
     * 先得到普通的通道
     * 通过通道对象的map()方法得到内存映射缓冲对象
     * <p>
     * 有了内存映射文件，就可以认为文件已经全部读进了内存，然后把它当成一个非常大的数组来访问。
     * <p>
     * 这种方法数据的传输速度非常快，但是非常耗费内存
     */
    private static void m3() {
        long start = System.currentTimeMillis();
        try (
                FileChannel inC = FileChannel.open(
                        Paths.get("src\\JavaSE.textNIO\\约定.flac"),
                        StandardOpenOption.READ
                );
                FileChannel outC = FileChannel.open(
                        Paths.get("src\\JavaSE.textNIO\\约定(copyByMapped).flac"),
                        StandardOpenOption.READ,    //后面跟得到内存映射缓冲区是只有READ_WRITE选项
                        StandardOpenOption.WRITE,
                        StandardOpenOption.CREATE
                )
        ) {
            MappedByteBuffer inMB = inC.map(MapMode.READ_ONLY, 0, inC.size());
            MappedByteBuffer outMB = outC.map(MapMode.READ_WRITE, 0, inC.size());
            byte[] by = new byte[inMB.limit()];

            inMB.get(by);
            outMB.put(by);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "mm");
    }

    /**
     * 直接使用通道来传输数据，（直接缓冲区）
     * transferTo()/transferFrom()
     */
    private static void m4() {
        long start = System.currentTimeMillis();
        try (
                FileChannel inC = FileChannel.open(
                        Paths.get("src\\JavaSE.textNIO\\约定.flac"),
                        StandardOpenOption.READ
                );
                FileChannel outC = FileChannel.open(
                        Paths.get("src\\JavaSE.textNIO\\约定(copyByTransfer).flac"),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.CREATE
                )
        ) {
            inC.transferTo(0, inC.size(), outC);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "mm");
    }

    private static void m5() {
        try (
                FileChannel inC = FileChannel.open(
                        Paths.get("src\\JavaSE.textNIO\\约定.flac"),
                        StandardOpenOption.READ
                );
                FileChannel outC = FileChannel.open(
                        Paths.get("src\\JavaSE.textNIO\\约定(copyByScatterAndGather).flac"),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.CREATE
                )
        ) {
            // 获得多个缓冲区，放在一个数组中
            ByteBuffer buf1 = ByteBuffer.allocate(1024);
            ByteBuffer buf2 = ByteBuffer.allocate(1024);
            ByteBuffer[] bufs = {buf1,buf2};

            //使用重载的方法进行读取和写入

            while(inC.read(bufs)!=-1) {
                for (ByteBuffer buf_ : bufs) {
                    buf_.flip();
                }
                outC.write(bufs);
                for (ByteBuffer buf_ : bufs) {
                    buf_.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符集对象来对缓冲区中的字符串进行编码和解码
     * 编码和解码都是对缓冲区中的字符（CharBuffer）和字节码（ByteBuffer）进行操作
     * 获取编码器和解码器之后进行调用，返回值也是缓冲区类型
     */
    private static void m6() throws CharacterCodingException {
        Charset gbk = Charset.forName("GBK");

        // 获取编码器en和解码器de
        CharsetEncoder en = gbk.newEncoder();
        CharsetDecoder de = gbk.newDecoder();

        // 构造需要编码的字符缓冲区
        CharBuffer cb = CharBuffer.allocate(1024);
        cb.put("略略略略略路略略略略略略");
        cb.flip();

        //编码和解码
        ByteBuffer enbuf = en.encode(cb);
        for(int i = 0; i < enbuf.limit(); i++){
            System.out.print(enbuf.get() + " ");
        }
        System.out.println();
        enbuf.flip();
        CharBuffer debuf = de.decode(enbuf);
        System.out.println(debuf.toString());

    }

}
