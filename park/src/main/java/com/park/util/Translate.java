package main.java.com.park.util;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Translate {
	static ServerSocket serverSocket;
	static Socket  socket;
	public Translate() throws IOException {
		serverSocket = new ServerSocket(8088);
		socket = serverSocket.accept();
		System.out.println("连接上啦");
	}
	
		public static String Send(String message) {
			try {
				
				PrintStream out=new PrintStream(socket.getOutputStream());
				out.print(message);
				//Thread.sleep(10000);
				out.close();
//				socket.close();
//				serverSocket.close();
				return "success";
			} catch (Exception se) {
				se.printStackTrace();
				return "false";
			}
		}
}

