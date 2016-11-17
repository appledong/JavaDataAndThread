package com.dong.thread.safethread.java;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class SemaphoreSet<T> {

	private final Set<T> set;
	private final Semaphore sem;

	public SemaphoreSet() {
		set = new HashSet<>();
		sem = new Semaphore(10);//控制set的最大容量是10
	}

	public void add(T t) throws InterruptedException {
		boolean isadd = false;
		try {
			sem.acquire();//获取许可，判断当前set数量是否满了，满了会阻塞add
			isadd = set.add(t);
		} finally {
			if (!isadd) {
				sem.release();//add失败，销毁许可
			}
		}
	}

	public void remove(T t) {
		boolean isadd = set.remove(t);
		if(isadd){
			sem.release();	//移除元素释放一个许可
		}
	}

}
