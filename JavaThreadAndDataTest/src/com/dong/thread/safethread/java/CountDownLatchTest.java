package com.dong.thread.safethread.java;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁CountDownLatch的使用
 * 
 * @author dong
 *
 */
public class CountDownLatchTest {

	/**
	 * 统计多个线程执行同一个task从启动到结束所花费的时间
	 * 
	 * @param threadnum
	 * @param task
	 * @return
	 */
	public long timesTask(int threadnum, final Runnable task)
			throws InterruptedException {
		final CountDownLatch startLatch = new CountDownLatch(1);
		final CountDownLatch endLatch = new CountDownLatch(threadnum);
		for (int i = 0; i < threadnum; i++) {
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						startLatch.await();//阻塞所有的线程
						try {
							task.run();
						} finally {
							endLatch.await();//线程执行完会执行减一操作
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			});
			thread.start();
		}
		long start = System.nanoTime();
		startLatch.countDown();// 放行所有的线程
		endLatch.await();//判断线程是否都执行完
		long end = System.nanoTime();
		return end - start;
	}

}
