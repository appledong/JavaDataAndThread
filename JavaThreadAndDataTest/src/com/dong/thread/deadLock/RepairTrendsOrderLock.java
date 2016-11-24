package com.dong.thread.deadLock;

/**
 * 修复并发编程中动态执行逻辑的顺序造成死锁
 * 
 * @author dong
 *
 */
public class RepairTrendsOrderLock {

	/**
	 * 死锁的造成是由外面的执行顺序造成的
	 * 
	 * @param from
	 * @param to
	 * @param money
	 */
	private void transMoney(Account from, Account to, int money) {
		int fhc = from.hashCode();
		int thc = to.hashCode();
		if (fhc < thc) {
			synchronized (from) {
				synchronized (to) {
					// TODO 执行转账的逻辑
				}
			}
		} else if (fhc > thc) {
			synchronized (to) {
				synchronized (from) {
					// TODO 执行转账的逻辑
				}
			}
		} else{//hashcode相同，对象相同则持有内置锁或者加赛锁
			synchronized (this) {
				// TODO 执行转账的逻辑
			}
		}

	}

	class Account {

	}

}
