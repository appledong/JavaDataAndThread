package com.dong.thread.safethread.demo.bingfacache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapCache<T, V> implements ComputeInterface<T, V> {

	/**
	 * 将线程安全性委托给了并发容器ConcurrentHashMap
	 */
	private final Map<T, V> cacheMap = new ConcurrentHashMap<T, V>();
	private final ComputeInterface<T, V> c;

	public ConcurrentHashMapCache(ComputeInterface<T, V> compute) {
		this.c = compute;
	}

	/**
	 * 线性安全，但是存在一个问题：由于并发容器允许多个线程的读写操作同时访问容器所以一个
	 * 线程在计算和写数据的时候不能阻挡读线程的访问，有可能存在多次计算的情况
	 */
	@Override
	public V compute(T t) {
		V v = cacheMap.get(t);
		if (v == null) {
			v = c.compute(t);
			cacheMap.put(t, v);
		}
		return v;
	}

}
