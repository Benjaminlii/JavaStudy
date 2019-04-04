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
 * ʹ��NIO�������ͨ�ŵ��������ģ�
 * ��������|- ͨ����Channel������������ͨѶ������
 * ��������|- ��������Buffer�����������ݴ洢
 * ��������|- ѡ������Selector������SelectableChannel�Ķ�·������������������
 * �����������������������������������ڼ��SelectableChannel��IO״��
 * ����������������|- SelectableChannel
 * ������������������������|- SocketChannel
 * ������������������������|- ServerSocketChannel
 * ������������������������|- DatagramChannel
 * ---------------------------------------------------------------------------------------------------------------------
 * ����ʹ������ʽNIO����ͨѶ�����ļ������˵��ύ
 * ---------------------------------------------------------------------------------------------------------------------
 * ����ʽ������ͨѶ����ʹ����ServerSocket��Socket���Channel
 * ��֮ǰ������ͨѶ��ͬ�������ݴ������֮����Ҫ����Socket��shutDownOutput()����
 * ---------------------------------------------------------------------------------------------------------------------
 * ����һ������
 * �ҵı�����ip��ַ��֪��Ϊʲô�ͱ��ˣ��������ⶫ�������İ�
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
 * ����ʽ�ͻ���
 */
class client {
    public static void main(String[] args) {

        try (
                SocketChannel sc = SocketChannel.open(
                        new InetSocketAddress("192.168.1.109", 50000)
                );
                FileChannel fc = FileChannel.open(
                        Paths.get("Լ��.flac"),
                        StandardOpenOption.READ
                )
        ) {
            //��������
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (fc.read(buf) != -1) {
                buf.flip();
                sc.write(buf);
                buf.clear();
            }
            sc.shutdownOutput();    //��ʾ�������

            // ���շ���˵ķ���
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
 * ����ʽ�����
 */
class Server {
    public static void main(String[] args) {
        try (
                ServerSocketChannel ssc = ServerSocketChannel.open();
                FileChannel fc = FileChannel.open(
                        Paths.get("Լ��(copyByServerSocket).flac"),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.CREATE
                )
        ) {
            ssc.bind(new InetSocketAddress(50000)); // ���÷���˵Ķ˿ں�
            SocketChannel sc = ssc.accept(); // ��ȡ���ӵ�����˵Ŀͻ���


            ByteBuffer buf = ByteBuffer.allocate(1024);

            while (sc.read(buf) != -1) {
                buf.flip();
                fc.write(buf);
                buf.clear();
            }

            buf.put("�������ݳɹ���".getBytes());
            buf.flip();
            sc.write(buf);

            // �ֶ��ر�SocketChannel�Ļ�  ������Ҫ��������״̬���л�
            // �������try-with�Զ��ر���Դ��������Ҫ�ֶ���֪�ͻ������ݴ������
            sc.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
