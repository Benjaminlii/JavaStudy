package JavaSE.textNet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ��IP��ַ����Ĳ���
 *
 * ����IP��ַ��DESKTOP-9HKOBH3/192.168.1.172
 *
 * author:Benjamin
 * date:2019.3.30
 */

public class TextIP {
    public static void main(String[] args) throws UnknownHostException {
        method_0();
    }

    // ʹ��net���е�InetAddress.getLocalHost();��ȡ���ص�IP��ַ
    public static void method_0() throws UnknownHostException {
        InetAddress one = InetAddress.getLocalHost();
        System.out.println(one);
    }

    // ����IP�����ƻ�ȡIP��ַ����
    public static void method_1() throws UnknownHostException {
        InetAddress one = InetAddress.getByName("www.baidu.com");
        System.out.println("name: " + one.getHostName());
        System.out.println("address: " + one.getHostAddress());
    }
}
