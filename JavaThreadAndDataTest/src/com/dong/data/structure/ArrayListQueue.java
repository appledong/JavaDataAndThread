package com.dong.data.structure;

import java.util.ArrayList;
import java.util.Queue;

/**
 * LinkedList表达队列
 * 
 * @author dong 队列特点：队尾入队头出，先进先出后进后出
 */
public class ArrayListQueue {

	private ArrayList<String> arrayList;

	public ArrayListQueue() {
		arrayList = new ArrayList<String>();
	}

	public void addToQueue(String str) {
		arrayList.add(str);
	}

	public String removeFromQueue() {
		if (arrayList == null || arrayList.size() == 0) {
			return "";
		}
		String str = arrayList.get(arrayList.size() - 1);
		arrayList.remove(arrayList.size() - 1);
		return str;
	}

	public String getQueue() {
		if (arrayList == null || arrayList.size() == 0) {
			return "";
		}
		String str = arrayList.get(arrayList.size() - 1);
		return str;
	}

	public int size() {
		return arrayList.size();
	}

}
