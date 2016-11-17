package com.dong.data;

import com.dong.data.structure.LinkedListStack;

public class StackTest {

	public static boolean checkStr() {
		String str = "{这是一个[测试，测试字符串)符号是不是]成对出现}";
		LinkedListStack linkedListStack = new LinkedListStack();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if ("{[(".contains(String.valueOf(ch))) {
				System.out.println("dongdianzhou1" + ch);
				linkedListStack.push(String.valueOf(ch));
			}
			if ("}])".contains(String.valueOf(ch))) {
				System.out.println("dongdianzhou2" + ch);
				String str2 = linkedListStack.pop();
				if (str2.equals("")) {
					return false;
				}
			}
		}
		if (linkedListStack.size() != 0) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		if (checkStr()) {
			System.out.println("字符串中的符号成对出现的");
		}
	}

}
