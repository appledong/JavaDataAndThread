package com.dong.thread.safethread.demo.bingfacache;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 
 * @author dong
 *
 */
public class FutureTaskAndAtomicCache<T, V> implements ComputeInterface<T, V> {
	/**
	 * ConcurrentHashMap缓存的是FutureTask不是V
	 */
	private final ConcurrentHashMap<T, FutureTask<V>> cacheMap = new ConcurrentHashMap<T, FutureTask<V>>();
	private final ComputeInterface<T, V> c;

	public FutureTaskAndAtomicCache(ComputeInterface<T, V> compute) {
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
			/**
			 * 并发编程中由于ConcurrentHashMap是并发访问的，所以ft有可能创建多个
			 * 不能直接使用
			 */
			FutureTask<V> ft = new FutureTask<V>(callable);
			/**
			 * putIfAbsent:如果存在就不插入，而且线程操作是原子性的
			 * 返回值：存在key返回key的映射值，如果不存在返回空
			 * 第一次f为null，进行ft赋值运行，第二次加入的时候由于原子性
			 * 会阻塞，直到完成再执行第二次加入时判断已经加入了不再加入。
			 * 保证map中key的映射值在多线程中只有一个值
			 */
			f = cacheMap.putIfAbsent(t, f);
			if (f == null) {//利用判空只有第一次启动计算，保证计算的唯一性
				f = ft;
				f.run();
			}
		}
		try {
			return f.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return null;
		}
	}
}
