package com.dong.thread;

import java.util.HashMap;
import java.util.Map;

import com.dong.thread.safethread.PersonHeatJavaMonitor2;
import com.dong.thread.safethread.bean.Person2;

public class PersonHeatJavaMonitor2Test {

	public static void main(String[] args) {
		Map<String, Person2> map = new HashMap<String, Person2>();
		map.put("1", new Person2("1"));
		map.put("2", new Person2("2"));
		map.put("3", new Person2("3"));
		map.put("4", new Person2("4"));
		map.put("5", new Person2("5"));
		PersonHeatJavaMonitor2 per = new PersonHeatJavaMonitor2(map);
		per.setPersonById("4", "9");
		Map<String, Person2> map2 = per.getPersons();
		for (String id : map2.keySet()) {
			Person2 per2 = map2.get(id);
			System.out.println(per2.heat);
		}
	}

}
