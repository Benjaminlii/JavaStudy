package JavaSE.textNet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 对IP地址对象的操作
 *
 * 本机IP地址：DESKTOP-9HKOBH3/192.168.1.172
 *
 * author:Benjamin
 * date:2019.3.30
 */

public class TextIP {
    public static void main(String[] args) throws UnknownHostException {
        method_0();
    }

    // 使用net包中的InetAddress.getLocalHost();获取本地的IP地址
    public static void method_0() throws UnknownHostException {
        InetAddress one = InetAddress.getLocalHost();
        System.out.println(one);
    }

    // 根据IP的名称获取IP地址对象
    public static void method_1() throws UnknownHostException {
        InetAddress one = InetAddress.getByName("www.baidu.com");
        System.out.println("name: " + one.getHostName());
        System.out.println("address: " + one.getHostAddress());
    }
}
