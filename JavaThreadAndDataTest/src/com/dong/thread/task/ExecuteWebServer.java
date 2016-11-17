package com.dong.thread.task;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecuteWebServer {

	public static void main(String[] args) throws IOException {
		final Executor executor = Executors.newFixedThreadPool(10);// 初始化了一个数量为10的有界线程池
		ServerSocket socket = new ServerSocket(80);
		/**
		 * 条件细节暂时不再处理
		 */
		while (true) {
			final Socket con = socket.accept();
			Runnable task = new Runnable() {

				@Override
				public void run() {
					handleRequest(con);
				}
			};
			executor.execute(task);
		}
	}

	/**
	 * 处理请求
	 * 
	 * @param con
	 */
	private static void handleRequest(Socket con) {

	}

}
