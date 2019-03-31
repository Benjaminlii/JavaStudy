package textNet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * 通过udp传输一段文字数据
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
     * 1、建立udp socket服务
     * 2、将数据封包
     * 3、通过socket发送数据包
     * 4、关闭资源
     */
    @Override
    public void run() {
        try {
            Object sync = new Object();

            DatagramSocket one = new DatagramSocket(9999);

            BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
            byte[] data;
            //参数表：（数据、数据长度、目标ip地址、目标端口）
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
     * 1、建立udp服务
     * 2、构造用于接受信息的数据包
     * 3、接受数据包
     * 4、关闭资源
     */
    @Override
    public void run() {
        try {
            //Socket需传入端口号，否则系统自动分配port
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
