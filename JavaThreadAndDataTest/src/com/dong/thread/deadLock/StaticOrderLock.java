package com.dong.thread.deadLock;

/**
 * 并发编程中静态执行对象的顺序造成死锁
 * @author dong
 *
 */
public class StaticOrderLock {

	private Object aObject = new Object();
	private Object bObject = new Object();

	private void leftToRight() {
		synchronized (aObject) {
			synchronized (bObject) {
				// TODO 执行逻辑代码
			}
		}
	}

	private void rightToLeft() {
		synchronized (bObject) {
			synchronized (aObject) {
				// TODO 执行逻辑代码
			}
		}
	}

}
