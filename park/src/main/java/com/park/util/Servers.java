/*
package com.park.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.park.serviceImpl.SocketServiceImp;
import com.park.vo.SocketEntity;
import com.alibaba.fastjson.JSONObject;



public class Servers extends Thread {
	private Socket socket = null;

	public void run() {
		ServerSocket serverSocket = null;
		
 

		try {
			serverSocket = new ServerSocket(8089);
			while (true) {
				socket = serverSocket.accept();
				System.out.println("连接上啦");
				PrintStream ps=new PrintStream(socket.getOutputStream());
			}catch() {
				}
			}

}
	*/



