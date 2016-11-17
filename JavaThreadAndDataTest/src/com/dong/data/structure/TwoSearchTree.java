package com.dong.data.structure;

import java.util.Map;

/**
 * 二叉查找树
 * 
 * @author dong
 * 树的添加规则？
 */
public class TwoSearchTree {

	/**
	 * 树的根节点
	 */
	private TreeNode root;

	public TreeNode add(int element) {
		if (root == null) {
			root = new TreeNode(element, null, null);
			return root;
		}
		return insert(root, element);
	}

	private TreeNode insert(TreeNode treeNode, int element) {
		TreeNode treeNode2 = null;
		int cpt = compareTo(treeNode.element, element);
		if (cpt > 0) {// Root 大
			if (treeNode.left == null) {
				treeNode.left = new TreeNode(element, null, null);
				return treeNode.left;
			} else {
				treeNode2 = insert(treeNode.left, element);
			}
		} else if (cpt < 0) {// 元素大
			if (treeNode.right == null) {
				treeNode.right = new TreeNode(element, null, null);
				return treeNode.right;
			} else {
				treeNode2 = insert(treeNode.right, element);
			}
		}
		return treeNode2;
	}

	// printTree
	public void printTree() {
		if (isEmpty()) {
			return;
		}
		System.out.println("先序遍历");
		printTreeByBefor(root);
		System.out.println("中序遍历");
		printTreeByMId(root);
		System.out.println("后序遍历");
		printTreeByAfter(root);
	}

	/**
	 * 先序遍历：中左右
	 * 
	 * @param treeNode
	 */
	private void printTreeByBefor(TreeNode treeNode) {
		System.out.println("treeNode:element:" + treeNode.element);
		if (treeNode.left != null) {
			printTreeByBefor(treeNode.left);
		}
		if (treeNode.right != null) {
			printTreeByBefor(treeNode.right);
		}
	}

	/**
	 * 中序遍历：左中右
	 * 
	 * @param treeNode
	 */
	private void printTreeByMId(TreeNode treeNode) {
		if (treeNode.left != null) {
			printTreeByMId(treeNode.left);
		}
		System.out.println("treeNode:element:" + treeNode.element);
		if (treeNode.right != null) {
			printTreeByMId(treeNode.right);
		}
	}

	/**
	 * 后序遍历：左右中
	 * 
	 * @param treeNode
	 */
	private void printTreeByAfter(TreeNode treeNode) {
		if (treeNode.left != null) {
			printTreeByAfter(treeNode.left);
		}
		if (treeNode.right != null) {
			printTreeByAfter(treeNode.right);
		}
		System.out.println("treeNode:element:" + treeNode.element);
	}

	// remove
	public void remove(int element) {
		if (isEmpty()) {
			throw new RuntimeException("当前树为空");
		}
		remove(root, element);
	}

	private void remove(TreeNode treeNode, int element) {
		if (treeNode == null) {
			throw new RuntimeException("当前树不存在此元素");
		}
		int cpt = compareTo(treeNode.element, element);
		if (cpt > 0) {// Root 大
			remove(treeNode.left, element);
		} else if (cpt < 0) {// 元素大
			remove(treeNode.right, element);
		} else if (treeNode.left != null && treeNode.right != null) {// 两个孩子
			treeNode.element = findmin(treeNode.right).element;
			remove(treeNode.right, treeNode.element);
		} else {
			if (treeNode.left == null && treeNode.right == null) {
				treeNode = null;
			} else {
				treeNode = treeNode.left == null ? treeNode.right
						: treeNode.left;
			}
		}
	}

	public TreeNode findmin() {
		return findmin(root);
	}

	// findmin
	private TreeNode findmin(TreeNode treeNode) {
		return treeNode.left == null ? treeNode : findmin(treeNode.left);
	}

	public TreeNode findmax() {
		return findmax(root);
	}

	// findmax
	private TreeNode findmax(TreeNode treeNode) {
		return treeNode.right == null ? treeNode : findmax(treeNode.right);
	}

	// get
	public TreeNode get(int element) {
		if (isEmpty()) {
			throw new RuntimeException("当前树为空");
		}
		TreeNode treeNode = get(root, element);
		if (treeNode == null) {
			throw new RuntimeException("当前树不存在这个元素");
		}
		return treeNode;
	}

	private TreeNode get(TreeNode treeNode, int element) {
		TreeNode treeNode2 = null;
		if (treeNode != null) {
			int cpt = compareTo(treeNode.element, element);
			if (cpt > 0) {// Root 大
				treeNode2 = get(treeNode.left, element);
			} else if (cpt < 0) {// 元素大
				treeNode2 = get(treeNode.right, element);
			} else {
				return treeNode;
			}
		}
		return treeNode2;
	}

	// contains
	public boolean contains(int element) {
		if (isEmpty()) {
			return false;
		}
		return contains(root, element);
	}

	private boolean contains(TreeNode treeNode, int element) {
		boolean isContain = false;
		if (treeNode == null) {
			System.out.println("treeNode:"+treeNode);
			return false;
		}
		int cpt = compareTo(treeNode.element, element);
		if (cpt > 0) {// Root 大
			isContain = contains(treeNode.left, element);
		} else if (cpt < 0) {// 元素大
			isContain = contains(treeNode.right, element);
		} else {
			return true;
		}
		return isContain;
	}

	// empty
	public boolean isEmpty() {
		return root == null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int compareTo(int lhs, int rhs) {
		return lhs - rhs;
	}

}
