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
 * Channel��ͨ����������Դ��Ŀ�꣬Java NIO�и��𻺳��������ݵĴ��䡣
 * ------------------------------------------------------------------------------------------
 * ͨ������Ҫʵ���ࣺ
 * java.nio.channels.Channel�ӿ�
 * ��������|- FileChannel
 * ��������|- SocketChannel
 * ��������|- ServerSocketChannel
 * ��������|- DatagramChannel
 * ------------------------------------------------------------------------------------------
 * ��ȡͨ����
 * 1��Java�ж�һЩIO���е����ṩ��getChannel()����
 * ��������|- ����IO��
 * ����������������|- FileInputStream��FileOutputStream
 * ��������|- ����IO��
 * ����������������|- Socket
 * ����������������|- ServerSocket
 * 2��JDK1.7֮��NIO.2�Ը���ͨ�����ṩ�˾�̬����open()
 * ��������|- eg:FileChannel.open(paths.get("sec\\1.png"), StanderOpenOption.READ);
 * 3��JDK1.7֮��NIO.2�е�Files������Ҳ�ṩ��newByteChannel()����
 * ------------------------------------------------------------------------------------------
 * ͨ��֮������ݴ��䣺
 * ��������|- transferFrom()
 * ��������|- transferTo()
 * ------------------------------------------------------------------------------------------
 * ��ɢ(Scatter)�;ۼ�(Gather)
 * ��������|-��ɢ��ȡ(Scattering Reads)����ͨ���е��ջ����ɢ�������������
 * ��������|-�ۼ�д��(Gathering Writes)��������������е����ݾۼ���ͨ����
 * ------------------------------------------------------------------------------------------
 * �ַ�����Charset
 * ����������|- ������ Encoder
 * ����������|- ������ Decoder
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
     * ͨ��IO���е�getChannel()�������Channel
     */
    private static void m1() {
        long start = System.currentTimeMillis();
        try (
                FileInputStream fis = new FileInputStream("src\\JavaSE.textNIO\\Լ��.flac");
                FileOutputStream fos = new FileOutputStream("src\\JavaSE.textNIO\\Լ��(copyByChannel1).flac");
                FileChannel inC = fis.getChannel();
                FileChannel outC = fos.getChannel()
        ) {
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (inC.read(buf) != -1) {
                // ѭ��ʹ�ö�ȡͨ������Դ�ļ��Ķ�ȡ
                // ÿ�ζ�ȡ�ж��Ƿ��������
                // ÿ�ζ�ȡ��֮�󣬽�������ת��Ϊ��ȡģʽ
                // ʹ��д��ͨ������Ŀ���ļ���д��
                // ÿ��ʹ���껺����֮����л���������������
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
     * ͨ��ͨ�����open()��������ͨ���Ļ�ȡ
     */
    private static void m2() {
        long start = System.currentTimeMillis();
        try (
                FileChannel inC = FileChannel.open(
                        Paths.get("src\\JavaSE.textNIO\\Լ��.flac"),
                        StandardOpenOption.READ     // ͨ������ͨ����������
                );
                FileChannel outC = FileChannel.open(
                        Paths.get("src\\JavaSE.textNIO\\Լ��(copyByChannel2).flac"),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.CREATE   //CREATE����ļ����ڣ����ǣ�CREATE_NEW����ļ����ڣ�����
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
     * ��ͨ��ֱ�ӽ������ڴ�ӳ���ļ������壩��
     * �ȵõ���ͨ��ͨ��
     * ͨ��ͨ�������map()�����õ��ڴ�ӳ�仺�����
     * <p>
     * �����ڴ�ӳ���ļ����Ϳ�����Ϊ�ļ��Ѿ�ȫ���������ڴ棬Ȼ���������һ���ǳ�������������ʡ�
     * <p>
     * ���ַ������ݵĴ����ٶȷǳ��죬���Ƿǳ��ķ��ڴ�
     */
    private static void m3() {
        long start = System.currentTimeMillis();
        try (
                FileChannel inC = FileChannel.open(
                        Paths.get("src\\JavaSE.textNIO\\Լ��.flac"),
                        StandardOpenOption.READ
                );
                FileChannel outC = FileChannel.open(
                        Paths.get("src\\JavaSE.textNIO\\Լ��(copyByMapped).flac"),
                        StandardOpenOption.READ,    //������õ��ڴ�ӳ�仺������ֻ��READ_WRITEѡ��
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
     * ֱ��ʹ��ͨ�����������ݣ���ֱ�ӻ�������
     * transferTo()/transferFrom()
     */
    private static void m4() {
        long start = System.currentTimeMillis();
        try (
                FileChannel inC = FileChannel.open(
                        Paths.get("src\\JavaSE.textNIO\\Լ��.flac"),
                        StandardOpenOption.READ
                );
                FileChannel outC = FileChannel.open(
                        Paths.get("src\\JavaSE.textNIO\\Լ��(copyByTransfer).flac"),
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
                        Paths.get("src\\JavaSE.textNIO\\Լ��.flac"),
                        StandardOpenOption.READ
                );
                FileChannel outC = FileChannel.open(
                        Paths.get("src\\JavaSE.textNIO\\Լ��(copyByScatterAndGather).flac"),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.CREATE
                )
        ) {
            // ��ö��������������һ��������
            ByteBuffer buf1 = ByteBuffer.allocate(1024);
            ByteBuffer buf2 = ByteBuffer.allocate(1024);
            ByteBuffer[] bufs = {buf1,buf2};

            //ʹ�����صķ������ж�ȡ��д��

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
     * �ַ����������Ի������е��ַ������б���ͽ���
     * ����ͽ��붼�ǶԻ������е��ַ���CharBuffer�����ֽ��루ByteBuffer�����в���
     * ��ȡ�������ͽ�����֮����е��ã�����ֵҲ�ǻ���������
     */
    private static void m6() throws CharacterCodingException {
        Charset gbk = Charset.forName("GBK");

        // ��ȡ������en�ͽ�����de
        CharsetEncoder en = gbk.newEncoder();
        CharsetDecoder de = gbk.newDecoder();

        // ������Ҫ������ַ�������
        CharBuffer cb = CharBuffer.allocate(1024);
        cb.put("����������·������������");
        cb.flip();

        //����ͽ���
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
