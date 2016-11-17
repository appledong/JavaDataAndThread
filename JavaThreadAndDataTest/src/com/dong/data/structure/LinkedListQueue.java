package com.dong.data.structure;

import java.util.LinkedList;

/**
 * LinkedList表达队列
 * 
 * @author dong 队列特点：队尾入队头出，先进先出后进后出
 */
public class LinkedListQueue {

	private LinkedList<String> linkedList;

	public LinkedListQueue() {
		linkedList = new LinkedList<String>();
	}

	public void addToQueue(String str) {
		linkedList.addLast(str);
	}

	public String removeFromQueue() {
		if (linkedList == null || linkedList.size() == 0) {
			return "";
		}
		String str = linkedList.getFirst();
		linkedList.removeFirst();
		return str;
	}

	public String getQueue() {
		if (linkedList == null || linkedList.size() == 0) {
			return "";
		}
		String str = linkedList.getFirst();
		return str;
	}

	public int size() {
		return linkedList.size();
	}

}
