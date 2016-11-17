package com.dong.thread.cache;

import java.util.concurrent.BlockingQueue;

public class ResponseInterrupted {

	/**
	 * 将中断异常继续对外抛出交给上层处理
	 * @param queue
	 * @return
	 * @throws InterruptedException
	 */
	public Integer getNextTask(BlockingQueue<Integer> queue)
			throws InterruptedException {
		return queue.take();
	}

	private boolean interrupted = false;

	/**
	 * 不允许继续抛异常的时候记录线程的中断状态在finally中处理:线程再次中断触发给上层，让上层解决
	 * @param queue
	 * @return
	 */
	public Integer getNextTask2(BlockingQueue<Integer> queue) {
		try {
			return queue.take();
		} catch (InterruptedException e) {
			interrupted = true;
			/**
			 * 由于方法限制不能继续抛异常，所以在上面记录了中断的状态，
			 * 此时把线程的中断请求恢复让其在finally中再次中断将中断异常
			 * 交给方法的调用者，让调用者去处理
			 */
			Thread.currentThread().interrupted();
			e.printStackTrace();
		} finally {
			if (interrupted) {
				Thread.currentThread().interrupt();
			}
		}
		return null;
	}

}
