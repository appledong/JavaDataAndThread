package com.dong.thread.safethread;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * java监视器模式：通过对象的内置锁或者私有对象锁对对象进行同步访问
 * 
 * @author dong
 *
 */
public class JavaMonitorMode {

	private final Set<AtomicInteger> intset = new HashSet<AtomicInteger>();

	private final Object myLock = new Object();

	public void addItem(AtomicInteger item) {
		synchronized (myLock) {
			intset.add(item);
		}
	}

	public synchronized boolean contains(AtomicInteger item) {
		synchronized (myLock) {
			return intset.contains(item);
		}
	}

	public synchronized boolean remove(AtomicInteger item) {
		synchronized (myLock) {
			return intset.remove(item);
		}
	}

}
