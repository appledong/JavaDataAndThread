package com.dong.thread.cancel;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class RenderThread extends Thread {

	private final Socket socket;
	private final InputStream in;

	public RenderThread(Socket socket) throws IOException {
		this.socket = socket;
		in = socket.getInputStream();
	}

	/**
	 * 通过重写使得IO任务中断，原因需要先了解IO的阻塞才能？？？？？
	 */
	@Override
	public void interrupt() {
		try {
			socket.close();
		} catch (IOException e) {

		} finally {
			super.interrupt();
		}
	}

	@Override
	public void run() {
		try {
			byte[] buf = new byte[1024];
			while (true) {
				int count = in.read(buf);
				if (count < 0) {
					break;
				} else {
					processBuilder(buf, count);
				}
			}
		} catch (IOException e) {
			//
		} finally{
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void processBuilder(byte[] buf, int count) {
		// TODO Auto-generated method stub

	}
}
