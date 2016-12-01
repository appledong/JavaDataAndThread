package com.dong.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutStreamTest {

	private final File file = new File("E:\\iostudy\\fileoutstream.txt");

	/**
	 * 写字节数组
	 */
	public void write() {
		try {
			FileOutputStream fileOutStream = new FileOutputStream(file);
			String str = "first write helloworde\r\n";
			try {
				fileOutStream.write(str.getBytes());
				fileOutStream.flush();
				fileOutStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 一个一个的写字节
	 */
	public void write2() {
		try {
			FileOutputStream fileOutStream = new FileOutputStream(file);
			String str = "first char first char write helloworde";
			try {
				byte[] b = str.getBytes();
				for (int i = 0; i < b.length; i++) {
					fileOutStream.write(b[i]);
				}
				fileOutStream.flush();
				fileOutStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 换行写
	 */
	public void write3() {
		try {
			FileOutputStream fileOutStream = new FileOutputStream(file);
			String str = "first char first char write\r\nhelloworde";
			try {
				byte[] b = str.getBytes();
				for (int i = 0; i < b.length; i++) {
					fileOutStream.write(b[i]);
				}
				fileOutStream.flush();
				fileOutStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 追加数据
	 */
	public void write4() {
		try {
			FileOutputStream fileOutStream = new FileOutputStream(file,true);
			String str = "\r\n\r\nfirst char first char write\r\nhelloworde";
			try {
				byte[] b = str.getBytes();
				for (int i = 0; i < b.length; i++) {
					fileOutStream.write(b[i]);
				}
				fileOutStream.flush();
				fileOutStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FileOutStreamTest fileOutputStream = new FileOutStreamTest();
		fileOutputStream.write();
		fileOutputStream.write2();
		fileOutputStream.write3();
		fileOutputStream.write4();
	}

}
