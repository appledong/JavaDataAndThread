package com.dong.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	private final File file = new File("E:\\iostudy\\filewriter.txt");

	/**
	 * 写整个字符数组
	 */
	public void write() {
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			String str = "first write char[] helloworde";
			writer.write(str.toCharArray());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 写整个字符串
	 */
	public void write2() {
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			String str = "first write string helloworde";
			writer.write(str);
			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * 单个字符去写
	 */
	public void write3() {
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			String str = "first write char helloworde";
			for (int i = 0; i < str.length(); i++) {
				writer.write(str.charAt(i));
			}
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * 换行写
	 */
	public void write4() {
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			String str = "first write char helloworde \r\n second write char helloworde";
			writer.write(str);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	/**
	 * 初始化File的时候没有设置File追加为true追加不起作用
	 */
	public void write5() {
		FileWriter writer = null;
		try {
			writer = new FileWriter(file,true);
			String str = "\r\nappend str methedtest";
			writer.write(str);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		FileWriterTest fileTest = new FileWriterTest();
		fileTest.write();
		fileTest.write2();
		fileTest.write3();
		fileTest.write4();
		fileTest.write5();
	}

}
