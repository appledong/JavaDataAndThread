package com.dong.thread.safethread.java;

import java.util.concurrent.BlockingQueue;

/**
 * 生产者队列，阻塞的存数据
 * 
 * @author dong
 *
 */
public class Producer implements Runnable {

	private int i = 0;

	private BlockingQueue<String> blockingQueue;

	public Producer(BlockingQueue<String> queue) {
		blockingQueue = queue;
	}

	public void run() {
		while (i < 10) {
			try {
				blockingQueue.put("生产者：" + i);
				Thread.sleep(1000);
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(i==10){
			try {
				Thread.sleep(1000);
				blockingQueue.put("生产者：" + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
