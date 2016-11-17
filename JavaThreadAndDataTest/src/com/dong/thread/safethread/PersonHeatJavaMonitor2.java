package com.dong.thread.safethread;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.dong.thread.safethread.bean.Person2;

/**
 * 线程安全性委托
 * 
 * @author dong
 *
 */
public class PersonHeatJavaMonitor2 {

	/**
	 * 对可变变量persons的线程安全委托给了线程安全的容器类ConcurrentHashMap去处理。
	 * 注意点：
	 * 	不需要返回副本快照，直接返回对象（即时状态）
	 */
	private final ConcurrentHashMap<String, Person2> persons;
	private final Map<String, Person2> unmpdifipersons;

	public PersonHeatJavaMonitor2(Map<String, Person2> persons) {
		this.persons = new ConcurrentHashMap<>(persons);
		unmpdifipersons = Collections.unmodifiableMap(this.persons);
	}

	/**
	 * @return 返回persons的一个映射，会随着修改而修改
	 */
	public Map<String, Person2> getPersons() {
		return unmpdifipersons;
	}

	public Person2 getPersonById(String id) {
		return persons.get(id);
	}

	public void setPersonById(String id, String heat) {
		persons.replace(id, new Person2(heat));
	}
}
