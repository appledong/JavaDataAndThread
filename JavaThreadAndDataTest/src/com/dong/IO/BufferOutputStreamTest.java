package com.dong.IO;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BufferOutputStreamTest {

	private final File file = new File("E:\\iostudy\\bufferoutputstream.txt");

	public void write() {
		OutputStream outputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			outputStream = new FileOutputStream(file);
			bufferedOutputStream = new BufferedOutputStream(
					outputStream);
			String str = "first char first byte: hello world";
			byte value[] = str.getBytes();
			for (int i = 0; i < value.length; i++) {
				bufferedOutputStream.write(value[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				bufferedOutputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void write2() {
		OutputStream outputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			outputStream = new FileOutputStream(file);
			bufferedOutputStream = new BufferedOutputStream(
					outputStream);
			String str = "first char first byte: hello world";
			byte value[] = str.getBytes();
			bufferedOutputStream.write(value);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				bufferedOutputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		BufferOutputStreamTest bost = new BufferOutputStreamTest();
		bost.write();
		bost.write2();
	}
}
