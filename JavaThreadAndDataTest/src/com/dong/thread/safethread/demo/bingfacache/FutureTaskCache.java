package com.dong.thread.safethread.demo.bingfacache;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 利用FutureTask的阻塞特性，get（）处于等待计算和计算中的状态，获取数据的线程会一直 阻塞等待计算完成返回数据
 * 
 * @author dong
 *
 * @param <T>
 * @param <V>
 */
public class FutureTaskCache<T, V> implements ComputeInterface<T, V> {

	/**
	 * ConcurrentHashMap缓存的是FutureTask不是V
	 */
	private final Map<T, FutureTask<V>> cacheMap = new ConcurrentHashMap<T, FutureTask<V>>();
	private final ComputeInterface<T, V> c;

	public FutureTaskCache(ComputeInterface<T, V> compute) {
		this.c = compute;
	}

	/**
	 * 和上面一样，由于ConcurrentHashMap的特性多个读写线程可以访问造成 多个线程中的f为空，同样多次计算
	 */
	@Override
	public V compute(final T t) {

		FutureTask<V> f = cacheMap.get(t);
		if (f == null) {
			Callable<V> callable = new Callable<V>() {

				@Override
				public V call() throws Exception {
					return c.compute(t);
				}
			};
			f = new FutureTask<>(callable);
			cacheMap.put(t, f);
		}
		f.run();
		try {
			return f.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return null;
		}
	}

}
