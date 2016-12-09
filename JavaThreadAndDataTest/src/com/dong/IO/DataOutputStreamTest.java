package com.dong.IO;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DataOutputStreamTest {

	private final File file = new File("E:\\iostudy\\dataoutputstream.txt");

	public void write() {
		OutputStream outputStream = null;
		DataOutputStream dataOutputStream = null;
		try {
			outputStream = new FileOutputStream(file);
			dataOutputStream = new DataOutputStream(outputStream);
			dataOutputStream.writeBytes("DataOutputStream test im byte array");
			dataOutputStream.writeInt(23);
			dataOutputStream.writeChars("chars write");
			dataOutputStream.writeFloat(2.3f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				outputStream.close();
				dataOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		DataOutputStreamTest dataOutputStreamTest = new DataOutputStreamTest();
		dataOutputStreamTest.write();
	}

}
