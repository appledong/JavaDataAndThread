package com.dong.thread.safethread.java;

import java.util.concurrent.BlockingQueue;

/**
 * 消费者队列：阻塞取数据
 * @author dong
 *
 */
public class Consumer implements Runnable {

	private BlockingQueue<String> blockingQueue;

	public Consumer(BlockingQueue<String> queue) {
		blockingQueue = queue;
	}

	public void run() {
		while (true) {
			String str = "";
			try {
				str = blockingQueue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("打印数据：" + str);
		}
	}
}
