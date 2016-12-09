package com.dong.IO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class BufferInputStreamTest {
	private final File file = new File("E:\\iostudy\\bufferoutputstream.txt");
	
	/**
	 * inputStream关闭以后还可以继续取数据说明
	 * 在第一次read的时候并不是read一个字节而是read
	 * 当前缓存数组的大小数据
	 */
	public void read(){
		try {
			InputStream inputStream = new FileInputStream(file);
			BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			byte first = (byte) bufferedInputStream.read();
			System.out.println(new String(new byte[]{first}));
			inputStream.close();
			byte second = (byte) bufferedInputStream.read();
			System.out.println(new String(new byte[]{second}));
			bufferedInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		BufferInputStreamTest bufferInputStreamTest = new BufferInputStreamTest();
		bufferInputStreamTest.read();
	}

}
