package com.dong.data.structure;

import java.util.LinkedList;

/**
 * LinkedList实现栈的架构
 * 
 * @author dong 栈：add，remove一个出口，先进后出，后进先出
 */
public class LinkedListStack {

	private LinkedList<String> linkedlist;

	public LinkedListStack() {
		linkedlist = new LinkedList<String>();
	}

	public int size() {
		return linkedlist.size();
	}

	public void push(String str) {
		linkedlist.addFirst(str);
	}

	/**
	 * 弹出栈并获取栈顶元素
	 * 
	 * @return
	 */
	public String pop() {
		if (linkedlist == null || linkedlist.size() == 0) {
			return "";
		}
		String pop = linkedlist.getFirst();
		linkedlist.removeFirst();
		return pop;
	}

	/**
	 * 获取栈顶元素
	 * 
	 * @return
	 */
	public String top() {
		if (linkedlist == null || linkedlist.size() == 0) {
			return "";
		}
		return linkedlist.getFirst();
	}
}
