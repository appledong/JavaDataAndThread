package com.dong.thread.safethread.java;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class IteratorProblem {

	private Set<Integer> set;

	public IteratorProblem() {
		set = new HashSet<>();
	}

	public void add(int i) {
		synchronized (set) {
			set.add(i);
		}
	}

	public void remove(int index) {
		synchronized (set) {
			set.remove(index);
		}
	}

	/**
	 * 迭代打印set的数据
	 * 线程不安全的，迭代的过程中有可能其他线程修改了set，
	 * 进而set的iterator中的计数器发生改变，在iterator的hasnext和next中
	 * 都做了计数器的校验，如果发生改变会直接出异常ConcurrentmodificationException。
	 */
	public void print() {
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			Integer i = iterator.next();
			System.out.println("当前打印的i是：" + i);
		}
	}

	public void print2() {
		for (Integer i : set) {
			System.out.println("当前打印的i是：" + i);
		}
	}

	/**
	 * 下面两个都是线程安全同步的，在遍历过程中加入了容器的锁，遍历过程中
	 * 容器不允许其他的操作
	 */
	public void printsyn() {
		synchronized (set) {
			Iterator<Integer> iterator = set.iterator();
			while (iterator.hasNext()) {
				Integer i = iterator.next();
				System.out.println("当前打印的i是：" + i);
			}
		}
	}

	public void print2syn() {
		synchronized (set) {
			for (Integer i : set) {
				System.out.println("当前打印的i是：" + i);
			}
		}
	}

	/**
	 * 下面两个遍历没有实现同步，但是在需要迭代的时候取了当前状态 的
	 * 副本快照进行迭代。
	 */
	public void safeprintunsyn() {
		Set<Integer> set2 = Collections.unmodifiableSet(set);
		Iterator<Integer> iterator = set2.iterator();
		while (iterator.hasNext()) {
			Integer i = iterator.next();
			System.out.println("当前打印的i是：" + i);
		}
	}

	public void safeprint2unsyn() {
		Set<Integer> set2 = Collections.unmodifiableSet(set);
		for (Integer i : set2) {
			System.out.println("当前打印的i是：" + i);
		}
	}

	/**
	 * 隐形迭代：有的时候并不是明显的获取iterator去迭代，而是在系统的逻辑操作或者
	 * 有些地方进行了隐式迭代，比如set的toString()就在内在实现中实现了set的迭代遍历
	 */
	public void hideIterator() {
		for (int i = 0; i < 10; i++) {
			add(i);
		}
		System.out.println("当前的set是：" + set.toString());
	}

}
