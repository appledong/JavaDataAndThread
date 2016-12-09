package com.dong.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;

public class PushbackInputStreamTest {

	private final File file = new File("E:\\iostudy\\pushbackstream.txt");

	public void write() {
		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(file);
			String str = "test pushbackstream content";
			outputStream.write(str.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void read() {
		InputStream inputStream = null;
		PushbackInputStream pushbackInputStream = null;
		try {
			inputStream = new FileInputStream(file);
			pushbackInputStream = new PushbackInputStream(inputStream);
			byte first = (byte) pushbackInputStream.read();
			pushbackInputStream.unread(first);
			byte second = (byte) pushbackInputStream.read();
			System.out.println("first字符：" + new String(new byte[]{first}) + " second字符：" + new String(new byte[]{second}));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		PushbackInputStreamTest pushbackInputStreamTest = new PushbackInputStreamTest();
		pushbackInputStreamTest.write();
		pushbackInputStreamTest.read();
	}

}
