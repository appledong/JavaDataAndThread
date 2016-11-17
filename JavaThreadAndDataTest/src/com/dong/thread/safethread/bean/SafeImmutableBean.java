package com.dong.thread.safethread.bean;

import java.util.ArrayList;

/**
 * 可变变量标识不可变的情况
 * @author dong
 *
 */
public class SafeImmutableBean {

	/**
	 * private标识对象作用域仅是当前类对象
	 * final标识list是不可修改
	 */
	private final ArrayList<Person2> list;

	/**
	 * 初始化时元素完全添加标识list是引用对象不可变的，不允许多线程修改
	 * 此时注意list不能逸出，一旦逸出还是存在多线程的风险
	 */
	public SafeImmutableBean() {
		list = new ArrayList<Person2>();
		list.add(new Person2());
		list.add(new Person2());
		list.add(new Person2());
	}

	public boolean contains(Person2 person2) {
		return list.contains(person2);
	}

	public Person2 getPerson(int index) {
		return list.get(index);
	}

}
