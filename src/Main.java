import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.*;

/**
 * whatever,write something.
 * <p>
 * author:Benjamin
 * date:2018.12.24
 */


public class Main {

    public static SocketChannel socketChannel;

    static {
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress("192.168.1.133",6666));
            //socketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Scanner scanner = new Scanner(System.in);

        new Thread(new ReceiveMsgClien()).start();

        while (scanner.hasNext()){
            buffer.put(scanner.nextLine().getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }

    }

    public static class ReceiveMsgClien implements Runnable{
        @Override
        public void run() {

            try {
                while(true){
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    int len = socketChannel.read(buffer);

                    if(len > 0){
                        buffer.flip();
                        System.out.println(new String(buffer.array(),0,len));
                        buffer.clear();
                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}