package JavaSE.textNet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * ͨ��URL���URLConnection����ʸ���url�е���Ϣ
 *
 * URL�ཫ������url��װ�ɶ���ͨ��һЩget�����õ����е�����
 * URLConnection����URL.openConnection()�������أ��Ѿ����أ����������Ѿ���������
 *
 * Ҫ�õ����������ص���Ϣ��Ҫʹ��URLConnection���е�InputStream��Socket�з�װ��
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
