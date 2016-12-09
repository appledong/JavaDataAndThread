package com.dong.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamTest {

	private final File file = new File("E:\\iostudy\\objectoutputstream.txt");

	public void read() {
		InputStream inputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			inputStream = new FileInputStream(file);
			objectInputStream = new ObjectInputStream(inputStream);
			ObjectBean objectBean = null;
			try {
				objectBean = (ObjectBean) objectInputStream.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println(objectBean.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				objectInputStream.close();
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ObjectInputStreamTest objectInputStreamTest = new ObjectInputStreamTest();
		objectInputStreamTest.read();
	}

}
