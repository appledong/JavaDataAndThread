package com.dong.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintlnStreamTest {

	private final File file = new File("E:\\iostudy\\printlnstream.txt");

	public void write() {
		PrintStream printStream = null;
		try {
			printStream = new PrintStream(file);
			printStream.print("test printstream");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally{
			printStream.close();
		}
	}
	
	public static void main(String[] args) {
		PrintlnStreamTest printlnStreamTest = new PrintlnStreamTest();
		printlnStreamTest.write();
	}

}
