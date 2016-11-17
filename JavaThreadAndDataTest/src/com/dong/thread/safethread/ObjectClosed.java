package com.dong.thread.safethread;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实例封闭和加锁结合，将整个程序对set的同步访问转移到对实体类的同步访问，从而简化了线程访问数据对锁的持有。
 * 
 * @author dong
 *
 */
public class ObjectClosed {

	/**
	 * 注意点： 封闭的容器对象必须私有权限，将对象的访问域封装到实体类中，缩小对象的访问域。
	 * 封装到实体的对象是final类型的，对象的作用域也仅限于封闭的实体类，注意不要对外发布对象，存在风险
	 * AtomicInteger是一个原子变量类型，操作都是原子性操作，线程安全的，如果是线程不安全的对象，引用对象内部也要做线程安全处理
	 */
	private final Set<AtomicInteger> intset = new HashSet<AtomicInteger>();

	public synchronized void addItem(AtomicInteger item) {
		intset.add(item);
	}

	public synchronized boolean contains(AtomicInteger item) {
		return intset.contains(item);
	}

	public synchronized boolean remove(AtomicInteger item) {
		return intset.remove(item);
	}

}
