package com.dong.thread.deadLock;

/**
 * 修复并发编程中静态执行对象的顺序造成死锁
 * 
 * @author dong
 *
 */
public class RepairStaticOrderLock {

	private Object aObject = new Object();
	private Object bObject = new Object();

	/**
	 * 由于方法的逻辑处理中需要持有两个对象锁，
	 * 而且 两个方法间锁的请求顺序造成死锁，
	 * 解决死锁的问题 将两个对象锁去掉换成两个方法的逻辑执行都持有当前
	 * 对象锁
	 */
	private synchronized void leftToRight() {
		// TODO 执行逻辑代码
	}

	private synchronized void rightToLeft() {
		// TODO 执行逻辑代码
	}

}
