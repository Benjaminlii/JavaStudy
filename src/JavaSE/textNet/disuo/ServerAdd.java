package JavaSE.textNet.disuo;

import java.net.Socket;
import java.util.Map;

public class ServerAdd implements Runnable {
    private Map<String, Socket> Sockets;

    public ServerAdd(Map<String, Socket> sockets) {
        Sockets = sockets;
    }

    @Override
    public void run() {

    }
}
