package com.dong.data;

import com.dong.data.structure.TreeNode;
import com.dong.data.structure.TwoSearchTree;

public class TreeTest {

//	public int get(int i) {
//		int j = 0;
//		if (i == 1) {
//			return i;
//		} else {
//			j = get(i - 1);
//		}
//		return j;
//	}

	public static void main(String[] args) {
		TwoSearchTree tst = new TwoSearchTree();
		for (int i = 1; i < 9; i++) {
			TreeNode treeNode = tst.add(i);
			System.out.println(treeNode);
		}
		tst.printTree();
		System.out.println("最大的数：" + tst.findmax().element);
		System.out.println("最小的数：" + tst.findmin().element);
		boolean is = tst.contains(3);
		System.out.println(tst.get(5));
		System.out.println(tst.hashCode());
//		System.out.println();
	}

}
