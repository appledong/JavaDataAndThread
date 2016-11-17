package com.dong.thread.safethread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 通过继承Java系统的线程安全类，利用加锁维持线程安全类的扩展逻辑的线程安全
 * 
 * @author dong
 *
 * @param <String>
 */
public class LockByHolder {

	private List list = new ArrayList<>();

	/**
	 * synchronizedList 对list的所有操作进行加锁处理
	 */
	public LockByHolder() {
		list = Collections.synchronizedList(list);
	}

	/**
	 * 此种写法有问题的，CopyOnWriteArrayList是线程安全的，但是contains和add两个
	 * 操作持有的锁是list对象，当前扩展的操作持有的锁对象是LockByHolder的内置锁，不是同一个 锁所以扩展到逻辑并不能线程同步。
	 * 
	 * @param str
	 * @return
	 */
	public synchronized boolean addIfAbsent(String str) {
		if (!list.contains(str)) {
			return list.add(str);
		}
		return false;
	}

	/**
	 * 对list加锁，这个逻辑和list的其他逻辑是同一个锁，线程同步的
	 * 
	 * @param str
	 * @return
	 */
	public boolean addIfAbsent2(String str) {
		synchronized (list) {
			if (!list.contains(str)) {
				return list.add(str);
			}
		}
		return false;
	}

}
