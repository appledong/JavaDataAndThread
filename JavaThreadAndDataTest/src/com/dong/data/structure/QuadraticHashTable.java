package com.dong.data.structure;

import java.util.HashMap;
import java.util.Hashtable;

public class QuadraticHashTable {

	private HashTableNode[] hashTableNodes;

	private int curentSize = 0;

	public QuadraticHashTable(int size) {
		hashTableNodes = new HashTableNode[size];
	}

	private int myHashCode(int hashcode) {
		if (hashTableNodes == null && hashTableNodes.length < 0) {
			throw new RuntimeException("没有初始化hash表");
		}
		return hashcode % hashTableNodes.length < 0 ? hashcode
				% hashTableNodes.length + hashTableNodes.length : hashcode
				% hashTableNodes.length;
	}

	// makeempty
	public void makeEmpty() {
		if (hashTableNodes != null && hashTableNodes.length > 0) {
			for (int i = 0; i < hashTableNodes.length; i++) {
				hashTableNodes[i] = null;
			}
		}
	}

	// empty
	public boolean empty() {
		if (hashTableNodes != null && hashTableNodes.length > 0) {
			if (hashTableNodes[0] != null) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	// add
	public void add(HashTableNode hashTableNode) {
		int hashcode = myHashCode(hashTableNode.hashCode());
		if (hashTableNodes[hashcode] == null) {
			hashTableNodes[hashcode] = hashTableNode;
		} else {
			// 利用f(i)=i线性查找
			for (int i = 0; i < hashTableNodes.length; i++) {
				if (hashTableNodes[i] == null) {
					hashTableNodes[i] = hashTableNode;
					hashTableNodes[i].isactive = true;
					break;
				}
			}
		}
		curentSize++;
		if (curentSize > hashTableNodes.length) {
			reHash();
		}
	}

	// remove
	public void remove(HashTableNode hashTableNode) {
		int hashcode = myHashCode(hashTableNode.hashCode());
		if (hashTableNodes[hashcode] != null
				&& hashTableNodes[hashcode].equals(hashTableNode)) {
			hashTableNodes[hashcode].isactive = false;
		} else {
			for (int i = 0; i < hashTableNodes.length; i++) {
				if (hashTableNodes[i] != null
						&& hashTableNodes[i].equals(hashTableNode)) {
					hashTableNodes[i].isactive = false;
					break;
				}
			}
		}
	}

	// contains
	public boolean contais(HashTableNode hashTableNode) {
		int hashcode = myHashCode(hashTableNode.hashCode());
		if (hashTableNodes[hashcode] != null
				&& hashTableNodes[hashcode].equals(hashTableNode)) {
			return true;
		} else {
			for (int i = 0; i < hashTableNodes.length; i++) {
				if (hashTableNodes[i] != null
						&& hashTableNodes[i].equals(hashTableNode)) {
					return true;
				}
			}
		}
		return false;
	}

	// print

	// rehash
	public void reHash() {
		HashTableNode[] hashTableNodes2 = hashTableNodes;
		hashTableNodes = new HashTableNode[hashTableNodes.length * 2];
		if (hashTableNodes2 != null && hashTableNodes2.length > 0) {
			for (int i = 0; i < hashTableNodes2.length; i++) {
				add(hashTableNodes2[i]);
			}
		}
	}
}
