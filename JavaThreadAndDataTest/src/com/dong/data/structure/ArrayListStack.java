package com.dong.data.structure;

import java.util.ArrayList;

public class ArrayListStack {

	private ArrayList<Integer> list;

	public ArrayListStack() {
		list = new ArrayList<Integer>();
	}

	public void push(Integer i) {
		list.add(0, i);
	}

	public int size() {
		return list.size();
	}

	public Integer pop() {
		if (list == null || list.size() == 0) {
			return 0;
		}
		Integer pop = list.get(0);
		list.remove(0);
		return pop;
	}

	public Integer top() {
		if (list == null || list.size() == 0) {
			return 0;
		}
		Integer pop = list.get(0);
		return pop;
	}

	// public static void main(String[] args) {
	// ArrayListStack arrayListStack = new ArrayListStack();
	// arrayListStack.push("1");
	// arrayListStack.push("2");
	// System.out.println(arrayListStack.pop());
	// System.out.println(arrayListStack.top());
	// }

}
