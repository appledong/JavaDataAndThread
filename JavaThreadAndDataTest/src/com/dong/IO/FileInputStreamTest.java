package com.dong.IO;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {

	private final File file = new File("E:\\iostudy\\fileoutstream.txt");

	/**
	 * 读字节数组
	 */
	public void readBytes() {
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] b = new byte[(int) file.length()];
			try {
				fileInputStream.read(b);
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("整块字节读出文件中的文本是：" + new String(b));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 读字节数组
	 *//*
	public void readBytes() {
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] b = new byte[10];
			try {
				
				fileInputStream.read(b);
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("整块字节读出文件中的文本是：" + new String(b));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * 一个一个的读字节
	 */
	public void read2() {
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] b = new byte[(int) file.length()];
			try {
				for (int i = 0; i < b.length; i++) {
					b[i] = (byte) fileInputStream.read();// 原本就是字节可以进行强转
				}
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("一个字节一个字节读出文件中的文本是：" + new String(b));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取未知文件大小:针对的是已知大小不会超过初始化数组的大小
	 */
	public void read3() {
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] b = new byte[1024];
			int temp = 0;
			int len = 0;
			try {
				while ((temp = fileInputStream.read()) != -1) {
					b[len] = (byte) temp;
					len++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("未知文件大小读出文件中的文本是：" + new String(b));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 读取未知文件大小:针对的是已知大小超过初始化数组的大小
	 * 此时借助bytearrayoutstream实现
	 */
	public void read4() {
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] b = new byte[10];
			try {
				while (fileInputStream.read(b) != -1) {
					outputStream.write(b);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("未知文件大小(超过给定数组时)读出文件中的文本是：" + new String(outputStream.toByteArray()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FileInputStreamTest fileOutputStream = new FileInputStreamTest();
		fileOutputStream.readBytes();
		fileOutputStream.read2();
		fileOutputStream.read3();
		fileOutputStream.read4();
	}

}
