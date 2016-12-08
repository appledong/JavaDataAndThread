package com.dong.IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteStreamTest {

	/**
	 * 内存操作流：内存中字节的读取和转存
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "HELLOWORLD";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				str.getBytes());
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		int temp = 0;
		while ((temp = inputStream.read()) != -1) {
			outputStream.write(Character.toLowerCase(temp));
		}
		System.out.println(new String(outputStream.toByteArray()));
		System.out.println("\r\n" + outputStream.toString());
	}
}
