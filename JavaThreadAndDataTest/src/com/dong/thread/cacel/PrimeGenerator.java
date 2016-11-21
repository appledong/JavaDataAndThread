package com.dong.thread.cacel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PrimeGenerator implements Runnable {

	private final List<BigInteger> list = new ArrayList<>();

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
				list.add(p);
			}
			/**
			 * 添加睡眠时间更好的说明线程的中断不是即时的，
			 * 因为设置中断时间和判断中断布尔值的时间不一定是同一个
			 * 时刻，特别是在计算逻辑比较复杂的
			 */
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("run: " + System.nanoTime());
	}

	public List<BigInteger> get() {
		return list;
	}

	public static void main(String[] args) {
		PrimeGeneratorBlockingQueue pg = new PrimeGeneratorBlockingQueue();
		new Thread(pg).start();
		try {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} finally {
			pg.setCancel();
		}
	}

}
