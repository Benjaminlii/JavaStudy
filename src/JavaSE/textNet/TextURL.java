package JavaSE.textNet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 通过URL类和URLConnection类访问给定url中的信息
 *
 * URL类将给出的url封装成对象，通过一些get方法得到其中的属性
 * URLConnection类由URL.openConnection()方法返回，已经返回，服务器便已经有了连接
 *
 * 要得到服务器发回的信息，要使用URLConnection类中的InputStream（Socket中封装）
 *
 * author:Benjamin
 * date:2019.3.31
 */

public class TextURL {
    public static void main(String[] args) throws IOException {
        methor_1();
    }

    public static void methor_0() throws MalformedURLException {
        URL url = new URL("http://192.168.1.172:8080/myWeb/HelloWorld.html?name = lt&year = 19");
        System.out.println("getProtocol() : " + url.getProtocol());
        System.out.println("getHost() : " + url.getHost());
        System.out.println("getPath() : " + url.getPath());
        System.out.println("getPort() : " + url.getPort());
        System.out.println("getFile() : " + url.getFile());
        System.out.println("getQuery() : " + url.getQuery());
    }

    public static void methor_1() throws IOException {
        URL url = new URL("http://192.168.1.172:8080/myWeb/HelloWorld.html");
        URLConnection conn = url.openConnection();

        System.out.println(conn);

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String s;
        while((s = in.readLine())!= null) {
            System.out.println(s);
        }
    }
}
