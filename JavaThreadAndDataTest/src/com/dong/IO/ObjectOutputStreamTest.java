package com.dong.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputStreamTest {

	private final File file = new File("E:\\iostudy\\objectoutputstream.txt");

	public void write() {
		OutputStream outputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			outputStream = new FileOutputStream(file);
			objectOutputStream = new ObjectOutputStream(outputStream);
			ObjectBean objectBean = new ObjectBean("001", "liming", 18);
			objectOutputStream.writeObject(objectBean);
			objectOutputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				objectOutputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

//	public void write2() {
//		OutputStream outputStream = null;
//		ObjectOutputStream objectOutputStream = null;
//		try {
//			outputStream = new FileOutputStream(file2);
//			objectOutputStream = new ObjectOutputStream(outputStream);
//			ObjectBean objectBean = new ObjectBean();
//			ObjectOutputStream.PutField putField = objectOutputStream
//					.putFields();
//			if (putField != null) {
//				putField.put("id", "100010");
//				putField.put("name", "中国联通");
//				putField.put("age", 18);
//			}
//			objectOutputStream.writeObject(objectBean);
//			objectOutputStream.writeFields();
//			objectOutputStream.flush();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				objectOutputStream.close();
//				outputStream.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	public static void main(String[] args) {
		ObjectOutputStreamTest objectOutputStreamTest = new ObjectOutputStreamTest();
		objectOutputStreamTest.write();
//		objectOutputStreamTest.write2();
	}

}
