package com.dong.thread.safethread.bean;

public class Person2 {

	/***
	 * 属性声明为不可变的，可以对外共享和发布
	 */
	public final String heat;// 体温

	public Person2() {
		heat = "0";
	}

	public Person2(String heat) {
		this.heat = heat;
	}
}
