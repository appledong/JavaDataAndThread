package com.dong.thread.safethread.demo.bingfacache;

import java.util.HashMap;
import java.util.Map;

public class LockCache<T, V> implements ComputeInterface<T, V> {

	private final Map<T, V> cacheMap = new HashMap<T, V>();
	private final ComputeInterface<T, V> c;

	public LockCache(ComputeInterface<T, V> compute) {
		this.c = compute;
	}

	/**
	 * hashmap线程不安全的，该缓存的线程安全性是通过加锁实现的
	 * 即对Compute加锁实现，存在缺点是：串行，一个线程在计算的时候，其他
	 * 所有的线程都被阻塞，等待计算完成
	 */
	@Override
	public synchronized V compute(T t) {
		V v = cacheMap.get(t);
		if (v == null) {
			v = c.compute(t);
			cacheMap.put(t, v);
		}
		return v;
	}

}
