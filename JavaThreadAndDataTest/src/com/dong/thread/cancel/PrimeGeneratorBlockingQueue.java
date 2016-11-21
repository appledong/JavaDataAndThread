package com.dong.thread.cancel;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PrimeGeneratorBlockingQueue implements Runnable {

	private final BlockingQueue<BigInteger> blockingQueue = new LinkedBlockingQueue<>();

	/**
	 * 通过布尔值标识符实现线程间的中断协作机制
	 */
	private volatile boolean cancel = false;

	public void setCancel() {
		cancel = true;
		System.out.println("setCancel: " + System.nanoTime());
	}

	@Override
	public void run() {
		BigInteger p = BigInteger.ONE;
		while (!cancel) {
			p = p.nextProbablePrime();
			synchronized (this) {
				/***
				 * blockingQueue的put方法是阻塞的，处在阻塞的时候，设置boolean
				 * 取消任务是永远不能够去验证这个cancel的，此时这个线程任务永远不会消失
				 * 成为线程泄漏
				 */
				try {
					blockingQueue.put(p);
				} catch (InterruptedException e) {//队列在阻塞的时候遇到Interrupte会抛异常
					e.printStackTrace();
				};
			}
		}
		System.out.println("run: " + System.nanoTime());
	}

	public BlockingQueue<BigInteger> get() {
		return blockingQueue;
	}

	public static void main(String[] args) {
		PrimeGeneratorBlockingQueue pg = new PrimeGeneratorBlockingQueue();
		new Thread(pg).start();
		try {
			try {
				consume(pg.get().take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} finally {
			pg.setCancel();
		}
	}

	/**
	 * 消费者消费元素
	 * @param take
	 */
	private static void consume(BigInteger take) {
		
	}

}
