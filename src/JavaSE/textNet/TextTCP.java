package JavaSE.textNet;//package JavaSE.textNet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP���䷽ʽ��Ҫ���пͻ��������˵�ʵʱ����
 * SocketΪ�ͻ���
 * ServerSocketΪ�����
 * �������������ն������У���Ҫ������ע�͵�����Ҳ��֪��Ϊɶ
 *
 * �ͻ��˴Ӽ��̶�����ĸ����out�����͵������
 * �����ͨ��in���ܿͻ��˷��͵���Ϣ������תΪ��д�ٷ��ͻ�ȥ
 * �ͻ��˽��ܵ�����˷��ص���Ϣ֮���ӡ�ڿ���̨
 * <p>
 * author:Benjamin
 * date:2019.3.30
 */
public class TextTCP {
    public static void main(String[] args) throws IOException {
        // �������Ҫ����һ���˿�
        ServerSocket ss = new ServerSocket(8989);
        // ��ȡ���������ӵĿͻ��˶���
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostName() + ".....�����ӷ���ˡ�");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = new PrintStream(s.getOutputStream(), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.equals("bye"))
                break;
            out.println(line);
            line = br.readLine();
            System.out.println(line);
        }
        s.close();
        ss.close();
    }
    public static void main1(String[] args) throws IOException {
        // �������Ҫ����һ���˿�
        ServerSocket ss = new ServerSocket(8889);
        // ��ȡ���������ӵĿͻ��˶���
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostName() + ".....�����ӷ���ˡ�");
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        s.close();
        ss.close();
    }
}

/**
 * �ͻ��˳���
 */
class TcpClient {
    public static void main1(String[] args) throws IOException {
        // Socket�������ӷ����ʱ��Ҫ�ṩ�ͻ��˵�IP��ַ�Ͷ˿ں�
        Socket s = new Socket("192.168.1.172", 10001);

        // �ͻ��˺ͷ����֮��ͨѶ����Ҫ�������ݣ���Ҫ�����ͻ��������˵�io��
        // �ͻ�����Ҫ���������ֱ�������Socket֮��ͨѶ��io����һ���Ӽ��̶������ֵ�System.out
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = new PrintStream(s.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String line;
        while ((line = br.readLine()) != null) {
            out.println(line);
            System.out.println("server :" + in.readLine());
            if (line.equals("bye"))
                break;
        }

        s.close();
    }

}

/**
 * ����˳���
 */
class TcpServer {
    public static void main(String[] args) throws IOException {
        // �������Ҫ����һ���˿�
        ServerSocket ss = new ServerSocket(10001);

        // ��ȡ���������ӵĿͻ��˶���
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostName() + ".....�����ӷ���ˡ�");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintStream out = new PrintStream(s.getOutputStream(), true);

        String line;

        while ((line = in.readLine()) != null) {
            System.out.println(line);
            if (line.equals("bye"))
                break;
            out.println(line.toUpperCase());
        }

        s.close();
        ss.close();
    }
}
