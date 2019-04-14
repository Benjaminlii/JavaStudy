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
 * ʹ�÷�����ʽNIO����ͨѶ�����˷�������
 * �����൱�ڷ����һֱ���ߣ��ͻ��˿�������Ľ������Ӻ����ݴ��䣬���ҷ���˻�ͬʱ������Щ����
 * Ҳ�в�������˼
 * ---------------------------------------------------------------------------------------------------------------------
 * ������ѡ������Selector��
 * ---------------------------------------------------------------------------------------------------------------------
 * �ͻ���û��ʲô��ı仯��ֻ�ǽ��׽���ͨ����״̬��Ϊ������ʽ�������������ʽ�޶���
 * ����˲��ǳ���
 * �����������ȣ���Ҫ�õ�ѡ���������������ע�ᵽѡ�����У���ѡ�����˵ļ�������Ϊ����
 * ��������Ȼ��ʹ��select()�������м�����ѡ����������һ��Channel���ھ���״̬ʱ
 * ���������ͻὫ��ǰ������Channel��ѡ�������뼯���У�����������
 * ������������ѭ����ʹ�õ������õ����е�ѡ��������б���
 * ���������ж�ѡ��������ԣ�������Ӧ�Ĳ���
 * ���������������������߼��������Ƚ��н��վ���Channel���ж�
 * �����������������ҳ����ܾ�����Channel����ʵ���Ƿ���˵�ServerSocketChannel��
 * �����������������ҳ����ӵ�����˵Ŀͻ��˶�SocketChannel���������״̬Ҳ�ĳɷ�����ʽ
 * ������������������ע�ᵽѡ�����У����м���
 * ��������������������������ȡ����ʱ���Ϳ��Եõ����е�Channel�����������ݵĴ�����
 * ---------------------------------------------------------------------------------------------------------------------
 * SelectableChannel.configureBlocking(boolean)���л���ǰ����������
 *
 * Selector Selector.open()���õ������ҷ���ѡ����
 *
 * SelectableChannel.register(Selector,SelectionKey)������ǰ��SelectableChannelע�ᵽ�����ѡ�����У���ע������������
 *
 * int select()	���������ע���Channel��
 * ���������������м�����Ҫ�����IO ����ʱ���÷������أ�
 * ��������������Ӧ�õ�SelectionKey ���뱻ѡ���SelectionKey �����У��÷���������ЩChannel ��������
 *
 * selector.selectedKeys()���õ�ѡ�����е�����ѡ���
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
 * ������ʽNIO����ͨѶ�Ŀͻ���
 */
class client{
    public static void main(String[] args) throws IOException {
        InetAddress ip = InetAddress.getLocalHost();
        //��ȡͨ��
        SocketChannel sChannel = SocketChannel.open(
                new InetSocketAddress(ip.getHostAddress(),10001));
        //�л�����ģʽ
        sChannel.configureBlocking(false);
        //������
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //��������
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            buf.put((new Date().toString() + "  " + InetAddress.getLocalHost().getHostAddress() + "\n" + in.nextLine()).getBytes());
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }
        //�ر���
        sChannel.close();
    }
}

/**
 * �����
 */
class server{
    public static void main(String[] args) throws IOException {
        //ͨ��
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //�л�������ģʽ
        ssChannel.configureBlocking(false);
        //��ȡ���������ӵĿͻ���
        ssChannel.bind(new InetSocketAddress(10001));
        //��ȡѡ��������
        Selector selector = Selector.open();
        ssChannel.register(selector, SelectionKey.OP_ACCEPT); //����������������ݣ����Լ����������¼���
        //��ѯʽ��ȡѡ�����Ͼ������¼�,Selector.select()������������ע���Channel
        // ��������һ����Ҫ����IO����ʱ
        // ����Channelע���SelectionKey���뵽SelectionKey�����У�������������
        while(selector.select() > 0){
            // ʹ�õ��������б���
            Iterator<SelectionKey> sks = selector.selectedKeys().iterator();
            while(sks.hasNext()){
                //�õ���������ѡ���
                SelectionKey sk = sks.next();
                //�ж�����һ�ּ��������¼���������ֻ�н��պͶ�ȡ�¼�
                if(sk.isAcceptable()){
                    //��ȡ���վ���״̬�ķ���������ӵĿͻ���
                    //����Ϊ������ģʽ
                    //ע�ᵽѡ������
                    SocketChannel sChannel = ssChannel.accept();
                    sChannel.configureBlocking(false);
                    sChannel.register(selector,SelectionKey.OP_READ);
                }else if(sk.isReadable()){
                    //�ж�ȡ״̬��������ô������е�ͨ�����������ݴ���
                    //��ȡѡ�����ж�������ͨ��,���ǣ�sk�Ƕ�ȡģʽ��ѡ���
                    SocketChannel sc = (SocketChannel)sk.channel();
                    //׼�����������Լ����ݵĽ���
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
