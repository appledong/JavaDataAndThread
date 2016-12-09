package com.dong.IO;

import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String id;
	public String name;
	public int age;
	
	public ObjectBean(){
		
	}
	
	public ObjectBean(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "ObjectBean [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
//	private void writeObject(ObjectOutputStream out) {
//		// TODO Auto-generated method stub
//
//	}

}
