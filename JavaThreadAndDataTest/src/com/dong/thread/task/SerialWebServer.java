package com.dong.thread.task;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟串行处理服务器请求数据
 * @author dong
 *
 */
public class SerialWebServer {
	
	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(80);
		/**
		 * 条件细节暂时不再处理
		 */
		while(true){
			Socket con = socket.accept();
			handleRequest(con);
		}
	}

	/**
	 * 处理请求
	 * @param con
	 */
	private static void handleRequest(Socket con) {
		
	}

}
