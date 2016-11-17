package com.dong.thread.safethread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.dong.thread.safethread.bean.Person;

/**
 * java监视器模式实现的一个人的体温检测器
 * @author dong
 *
 */
public class PersonHeatJavaMonitor {

	private final Map<String, Person> persons;

	public PersonHeatJavaMonitor(Map<String, Person> persons) {
		this.persons = deepCopy(persons);
	}

	/**
	 * 对外发布的是map实体的快照备份
	 * 优点：外面访问的不是对象本体，减少了风险
	 * 缺点：大批量数据的时候影响性能
	 * 获取的是快照，所以获取到的数据不是即时数据
	 * @return
	 */
	public synchronized Map<String, Person> getPersons() {
		return deepCopy(persons);
	}

	public synchronized Person getPersonById(String id) {
		Person person = persons.get(id);
		return person == null ? null : new Person(person);
	}

	public synchronized void setPersonById(String id, String heat) {
		Person person = persons.get(id);
		person.heat = heat;
	}

	private Map<String, Person> deepCopy(Map<String, Person> persons2) {
		Map<String, Person> persons = new HashMap<String, Person>();
		for (String id : persons2.keySet()) {
			persons.put(id, persons2.get(id));
		}
		return Collections.unmodifiableMap(persons);
	}
}
