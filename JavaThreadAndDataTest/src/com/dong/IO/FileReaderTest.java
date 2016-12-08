package com.dong.IO;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	private final File file = new File("E:\\iostudy\\fileoutstream.txt");

	public void read() {
		FileReader reader = null;
		try {
			reader = new FileReader(file);
			char[] str = new char[150];
			try {
				reader.read(str);
				System.out.println("字符数组读取：" + new String(str, 0, str.length));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void read2() {
		FileReader reader = null;
		try {
			reader = new FileReader(file);
			char str[] = new char[150];
			try {
				for (int i = 0; i < str.length; i++) {
					str[i] = (char) reader.read();
				}
				System.out
						.println("单个单个字符读取：" + new String(str, 0, str.length));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void read4() {
		FileReader reader = null;
		try {
			reader = new FileReader(file);
			CharArrayWriter charArrayWriter = new CharArrayWriter();
			char str[] = new char[10];
			try {
				while (reader.read(str) != -1) {
					charArrayWriter.write(str);
				}
				System.out
						.println("借助CharArrayWriter读取未知大小的File：" + new String(charArrayWriter.toCharArray()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 跳过前面7个字符
	 */
	public void read3() {
		FileReader reader = null;
		try {
			reader = new FileReader(file);
			char[] str = new char[150];
			try {
				reader.skip(7);
				reader.read(str);
				System.out.println("跳过前面字符字符数组读取："
						+ new String(str, 0, str.length));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		FileReaderTest readerTest = new FileReaderTest();
		readerTest.read();
		readerTest.read2();
		readerTest.read3();
		readerTest.read4();
	}

}
