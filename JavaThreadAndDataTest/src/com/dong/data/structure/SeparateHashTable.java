package com.dong.data.structure;

import java.util.LinkedList;

/**
 * hashcode一样值重复hash表结构
 * 
 * @author dong 相同hashcode放到list中
 */
public class SeparateHashTable {

	LinkedList<HashTableNode>[] list;

	public SeparateHashTable(int size) {
		list = new LinkedList[size];
		for (int i = 0; i < list.length; i++) {
			list[i] = new LinkedList<HashTableNode>();
		}
	}

	private int myHashCode(int hashcode) {
		if (list == null && list.length < 0) {
			throw new RuntimeException("没有初始化hash表");
		}
		return hashcode % list.length < 0 ? hashcode % list.length
				+ list.length : hashcode % list.length;
	}

	// makeempty
	public void makeEmpty() {
		if (list != null && list.length > 0) {
			for (int i = 0; i < list.length; i++) {
				list[i].clear();
			}
		}
	}

	// empty
	public boolean empty() {
		if (list != null && list.length > 0) {
			for (int i = 0; i < list.length; i++) {
				if (list[i].size() > 0) {
					return false;
				}
			}
			return true;
		} else {
			return true;
		}
	}

	// add
	public void add(HashTableNode hashTableNode) {
		int hashcode = myHashCode(hashTableNode.hashCode());
		if (!list[hashcode].contains(hashTableNode)) {
			list[hashcode].add(hashTableNode);
		}
	}

	// remove
	public void remove(HashTableNode hashTableNode) {
		int hashcode = myHashCode(hashTableNode.hashCode());
		if (list[hashcode].contains(hashTableNode)) {
			list[hashcode].remove(hashTableNode);
		}
	}

	// get
	public void print() {
		if (list != null && list.length > 0) {
			for (int i = 0; i < list.length; i++) {
				for (int j = 0; j < list[i].size(); j++) {
					HashTableNode hashTableNode = list[i].get(j);
					System.out.println(hashTableNode.toString());
				}
			}
		}
	}

	// contains
	public boolean contains(HashTableNode hashTableNode) {
		int hashcode = myHashCode(hashTableNode.hashCode());
		if (list[hashcode].contains(hashTableNode)) {
			return true;
		}
		return false;
	}

}
