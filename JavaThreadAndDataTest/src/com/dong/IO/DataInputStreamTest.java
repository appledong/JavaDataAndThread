package com.dong.IO;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DataInputStreamTest {

	private final File file = new File("E:\\iostudy\\dataoutputstream.txt");

	public void read() {
		InputStream inputStream = null;
		DataInputStream dataInputStream = null;
		try {
			inputStream = new FileInputStream(file);
			dataInputStream = new DataInputStream(inputStream);
			byte value[] = new byte[150];
			dataInputStream.read(value);
			System.out.println(new String(value));
			int i = dataInputStream.readInt();
			String test = dataInputStream.readLine();
			float f = dataInputStream.readFloat();
			System.out.println("i" + i + "test:" + test + "f:" + f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				dataInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		DataInputStreamTest dataInputStreamTest = new DataInputStreamTest();
		dataInputStreamTest.read();

	}

}
