package com.dong.data.structure;

public class HashTableNode {

	public String name;
	public String age;
	
	public boolean isactive = false;//用于不重复hashTable的删除

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return obj instanceof HashTableNode
				&& ((HashTableNode) obj).name.equals(name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

}
