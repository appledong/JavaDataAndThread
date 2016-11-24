package com.dong.thread.deadLock;

/**
 * 并发编程中动态执行逻辑的顺序造成死锁
 * 
 * @author dong
 *
 */
public class TrendsOrderLock {

	/**
	 * 死锁的造成是由外面的执行顺序造成的
	 * @param from
	 * @param to
	 * @param money
	 */
	private void transMoney(Account from, Account to, int money) {
		synchronized (from) {
			synchronized (to) {
				//TODO 执行转账的逻辑
			}
		}
	}

	class Account {

	}

}
