package com.dong.thread.safethread.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskPreData<T> {

	private final FutureTask<T> predata = new FutureTask<>(new Callable<T>() {

		@Override
		public T call() throws Exception {
			//TODO 准备数据，多是在单线程中
			return null;
		}
	});

	private final Thread thread = new Thread(predata);

	/**
	 * 对外提供线程，可以预加载
	 */
	public void start() {
		thread.start();
	}

	/**
	 * 使用数据的时候get，如果没有执行完成会阻塞，直到完成响应数据并触发阻塞的线程
	 * @return
	 */
	public T get() {
		T t = null;
		try {
			t = predata.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return t;
	}

}
