package textNet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * ͨ��udp����һ����������
 * <p>
 *
 * <p>
 * author:Benjamin
 * date:2019.3.30
 */

public class TextUDP {
    public static void main(String[] args) {
        new Thread(new send()).start();
        new Thread(new rece()).start();

    }
}

class send implements Runnable {
    /**
     * 1������udp socket����
     * 2�������ݷ��
     * 3��ͨ��socket�������ݰ�
     * 4���ر���Դ
     */
    @Override
    public void run() {
        try {
            Object sync = new Object();

            DatagramSocket one = new DatagramSocket(9999);

            BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
            byte[] data;
            //�����������ݡ����ݳ��ȡ�Ŀ��ip��ַ��Ŀ��˿ڣ�
            do {
                data = bufr.readLine().getBytes();
                DatagramPacket dataPack =
                        new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 10000);

                one.send(dataPack);
            } while (!new String(data).equals("bye"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class rece implements Runnable {
    /**
     * 1������udp����
     * 2���������ڽ�����Ϣ�����ݰ�
     * 3���������ݰ�
     * 4���ر���Դ
     */
    @Override
    public void run() {
        try {
            //Socket�贫��˿ںţ�����ϵͳ�Զ�����port
            DatagramSocket one = new DatagramSocket(10000);
            while (true) {
                byte[] data = new byte[1024];
                DatagramPacket dataPack = new DatagramPacket(data, data.length);

                one.receive(dataPack);

                String data_ = new String(dataPack.getData(), 0, dataPack.getLength());
                System.out.println("\t\t\t\t\t\t\t\t\t\t" + data_);
                if (data_.equals("bye")) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
