//package textNet;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �Զ���ͻ���
 * �����������
 * ����IP��ַ��DESKTOP-9HKOBH3/192.168.1.172
 *
 * ���ʲ���������
 * ��վ�㲻��ȫ
 *
 * author:Benjamin
 * date:2019.3.30
 */

public class TextDefServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10002);

        Socket s = ss.accept();

        System.out.println(s.getInetAddress().getHostAddress());

        PrintStream out = new PrintStream(s.getOutputStream(),true);

        out.println("���������ͻ���");

        s.close();

        ss.close();
    }
}
