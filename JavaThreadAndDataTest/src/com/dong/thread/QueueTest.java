package com.dong.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.dong.thread.safethread.java.Consumer;
import com.dong.thread.safethread.java.Producer;

/**
 * 生产者消费者多线程测试
 * @author dong
 *
 */
public class QueueTest {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new LinkedBlockingQueue<>();
		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();
	}

}
