package com.dong.thread.safethread.bean;

public class Person3 {

	/***
	 * 属性可以修改也可以对外发布，而且通过加锁的模式保持线程安全
	 */
	public String heat;// 体温

	public synchronized void setHeat(String heat) {
		this.heat = heat;
	}

	public synchronized String getHeat() {
		return heat;
	}
}
