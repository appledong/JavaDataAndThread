package com.dong.thread.safethread;

import java.util.Vector;

/**
 * 通过继承Java系统的线程安全类，利用加锁维持线程安全类的扩展逻辑的线程安全
 * @author dong
 *
 * @param <String>
 */
public class LockByExtends<String> extends Vector<String> {

	public synchronized boolean addIfAbsent(String str) {
		if (!contains(str)) {
			return add(str);
		}
		return false;
	}

}
