package com.dong.thread.safethread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程安全性委托失效
 * @author dong
 *
 */
public class NumberRange {

	/**
	 * low和high都是原子变量，其内的操作都是原子性
	 * 但是setlow和sethigh没有同步维护，这两个方法的操作不是原子性和可见性的，没有维持线性安全，
	 * 多线程访问的时候有可能出现（5,4）的问题：没有考虑好low<high这个约束条件
	 */
	private AtomicInteger low = new AtomicInteger(0);
	private AtomicInteger high = new AtomicInteger(0);

	public void setLow(int i) {
		if (i < high.get()) {
			low.set(i);
		}
	}

	public void sethigh(int i) {
		if (i > low.get()) {
			high.set(i);
		}
	}

	public boolean isInRange(int i) {
		return i >= low.get() && i <= high.get();
	}

}
