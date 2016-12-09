package com.dong.IO;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Vector;

public class SequenceInputStreamTest {

	private final File file = new File("E:\\iostudy\\fileoutstream.txt");
	private final File file2 = new File("E:\\iostudy\\bufferoutputstream.txt");

	public void read() {
		InputStream inputStream = null;
		InputStream inputStream2 = null;
		SequenceInputStream sequenceInputStream = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		try {
			inputStream = new FileInputStream(file);
			inputStream2 = new FileInputStream(file2);
			 Vector<InputStream> vector = new Vector<>();
			 vector.add(inputStream);
			 vector.add(inputStream2);
			 sequenceInputStream = new SequenceInputStream(vector.elements());
//			sequenceInputStream = new SequenceInputStream(inputStream,
//					inputStream2);
//			byte value[] = new byte[1024];
//			sequenceInputStream.read(value);
//			System.out.println(new String(value));
			byteArrayOutputStream = new ByteArrayOutputStream();
			byte value[] = new byte[10];
			while (sequenceInputStream.read(value) != -1) {
				byteArrayOutputStream.write(value);
			}
			System.out.println(new String(byteArrayOutputStream.toByteArray()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sequenceInputStream.close();
				inputStream.close();
				inputStream2.close();
//				byteArrayOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		SequenceInputStreamTest sequenceInputStreamTest = new SequenceInputStreamTest();
		sequenceInputStreamTest.read();
	}

}
