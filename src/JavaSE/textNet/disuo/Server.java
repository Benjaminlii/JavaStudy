package JavaSE.textNet.disuo;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * �������������ͻ���ͨ�ŵ�����
 * ʹ�ö��߳������
 * Server�ദ����Ϣ�ķ��ͣ�����
 * ServerAdd�����ڽ���������ӣ�while��true��ѭ���ȴ�
 * ServerThread��Ϊ��������ӵ�ĳһ���ͻ���
 * ʹ��Map<String, Socket>���Ӹ���
 *
 * author:Benjamin
 * date:2019.5.13
 */
public class Server {

    private Map<String, Socket> Sockets = new HashMap<>();

    public static void main(String[] args) {
        method();
    }
    public static void method(){

    }
}
