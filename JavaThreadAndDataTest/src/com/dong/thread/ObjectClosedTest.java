package com.dong.thread;

import java.util.concurrent.atomic.AtomicInteger;

import com.dong.thread.safethread.JavaMonitorMode;

public class ObjectClosedTest {

	public static void main(String[] args) {
		final JavaMonitorMode objectClosed = new JavaMonitorMode();
		final AtomicInteger atomicInteger = new AtomicInteger(8);
		new Thread(new Runnable() {

			@Override
			public void run() {
				objectClosed.addItem(atomicInteger);
				System.out.println(objectClosed.contains(atomicInteger)+"oooo");
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(objectClosed.contains(atomicInteger));
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				objectClosed.remove(atomicInteger);
			}
		}).start();
	}

}
