package com.dong.thread.safethread;

import java.util.concurrent.CopyOnWriteArrayList;

import com.dong.thread.safethread.bean.KeyListener;
import com.dong.thread.safethread.bean.MouseListener;

/**
 * 线程安全性委托给两个可变变量
 * @author dong
 *
 */
public class ListenerMonitor {

	private final CopyOnWriteArrayList<KeyListener> keyListeners;
	private final CopyOnWriteArrayList<MouseListener> mouseListeners;

	public ListenerMonitor() {
		keyListeners = new CopyOnWriteArrayList<>();
		mouseListeners = new CopyOnWriteArrayList<>();
	}

	public void addKeyListener(KeyListener keyListener) {
		keyListeners.add(keyListener);
	}

	public void removeKeyListener(KeyListener keyListener) {
		keyListeners.remove(keyListener);
	}

	public void addMouseListener(MouseListener mouseListener) {
		mouseListeners.add(mouseListener);
	}

	public void removeMouseListener(MouseListener mouseListener) {
		mouseListeners.remove(mouseListener);
	}

}
