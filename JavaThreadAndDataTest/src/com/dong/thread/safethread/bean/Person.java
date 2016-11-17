package com.dong.thread.safethread.bean;

public class Person {

	public String heat;// 体温

	public Person() {
		heat = "0";
	}

	public Person(Person person) {
		heat = person.heat;
	}
}
