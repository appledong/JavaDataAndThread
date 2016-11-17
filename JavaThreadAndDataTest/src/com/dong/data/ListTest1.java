package com.dong.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest1 {

	public static void main(String[] args) {
		LinkedList linked;  
		
//		linked.get(index)
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			list.add("test" + i);
		}
		Iterator it = list.iterator();
		while (it.hasNext()) {
			// String str = (String) it.next();
			// list.remove(index)
			it.next();
			System.out.println("执行删除");
			it.remove();
//			list.indexOf(o)
		}
		System.out.println("当前的list size：" + list.size());
		for (String string : list) {
			System.out.println("String:" + string);
		}
	}

}
