package com.dong.thread.cancel;

import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class DelayRunnable {

	private final ScheduledExecutorService executorService = Executors
			.newScheduledThreadPool(4);

	public void timeRunning(Runnable task, long time, TimeUnit timeUnit) {
		final Thread taskThread = Thread.currentThread();
		executorService.schedule(new Runnable() {

			@Override
			public void run() {
				taskThread.interrupt();
			}
		}, time, timeUnit);
		task.run();
	}

	class RethrowRunnable implements Runnable {

		private volatile Throwable t;
		final Runnable r;

		public RethrowRunnable(Runnable r) {
			this.r = r;
		}

		public void run() {
			try {
				r.run();
			} catch (Throwable e) {
				t = e;
			}
		}

		public void reThrow() {
			if (t != null) {
				// throw t;//为了省事不再封装throwable t
			}
		}

	}

	private final ScheduledExecutorService executorService2 = Executors
			.newScheduledThreadPool(4);

	public void timeRunning2(Runnable task, long time, TimeUnit timeUnit) {
		RethrowRunnable rethrowRunnable = new RethrowRunnable(task);
		final Thread thread = new Thread(rethrowRunnable);
		thread.start();
		executorService2.schedule(new Runnable() {

			@Override
			public void run() {
				thread.interrupt();
			}
		}, time, timeUnit);
		try {
			thread.join(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		rethrowRunnable.reThrow();
	}
	
	private final ExecutorService executorService3 = Executors
			.newFixedThreadPool(4);
	
	public void timeRunning3(Runnable task, long time, TimeUnit timeUnit) {
		Future f = executorService3.submit(task);
		try {
			f.get(time, timeUnit);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} finally{
			f.cancel(true);
		}
	}

}
