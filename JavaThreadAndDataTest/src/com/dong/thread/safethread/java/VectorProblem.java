package com.dong.thread.safethread.java;

import java.util.Vector;

/**
 * Java的同步容器内的操作都是线程安全的，
 *  如果衍生了其他的逻辑操作没有外在同步的处
 *  理 下是线程不安全的
 * 
 * @author dong
 *
 */
public class VectorProblem {

	private Vector<String> vector;

	public VectorProblem() {
		vector = new Vector<>();
	}

	/**
	 * 线程不安全的
	 * 
	 * @return
	 */
	public String getLast() {
		int size = vector.size();
		return vector.get(size - 1);
	}

	/**
	 * 线程不安全的
	 * 
	 * @return
	 */
	public void removeLast() {
		int size = vector.size();
		vector.remove(size - 1);
	}

	/**
	 * 线程安全的
	 * 
	 * @return
	 */
	public String getLast2() {
		synchronized (vector) {
			int size = vector.size();
			return vector.get(size - 1);
		}
	}

	/**
	 * 线程安全的
	 * 
	 * @return
	 */
	public void removeLast2() {
		synchronized (vector) {
			int size = vector.size();
			vector.remove(size - 1);
		}
	}

}
