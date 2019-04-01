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
     * ͨ��IO���е�getChannel()�������Channel
     */
    private static void m1() {
        try (
                FileInputStream fis = new FileInputStream("src\\textNIO\\Լ��.flac");
                FileOutputStream fos = new FileOutputStream("src\\textNIO\\Լ��(copyByChannel1).flac");
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
    }

    /**
     * ͨ��ͨ�����open()��������ͨ���Ļ�ȡ
     */
    public static void m2() {
        try (
                FileChannel inC = FileChannel.open(
                        Paths.get("src\\textNIO\\Լ��.flac"),
                        StandardOpenOption.READ);   // ͨ������ͨ����������
                FileChannel outC = FileChannel.open(
                        Paths.get("src\\textNIO\\Լ��(copyByChannel2).flac"),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.CREATE) //CREATE����ļ����ڣ����ǣ�CREATE_NEW����ļ����ڣ�����

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
