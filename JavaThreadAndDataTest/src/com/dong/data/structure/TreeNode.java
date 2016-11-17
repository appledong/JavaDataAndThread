package com.dong.data.structure;

import java.util.Comparator;

/**
 * 定义一个树的节点类：只是声明了父子关系，没有声明兄弟关系
 * @author dong
 *	每一个节点都可能是叶子（左右孩子都没有）
 */
public class TreeNode<T> implements Comparator<T>{
	
	public int element;
	
	public TreeNode left;
	
	public TreeNode right;

	public TreeNode(int element, TreeNode left, TreeNode right) {
		super();
		this.element = element;
		this.left = left;
		this.right = right;
	}

	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
