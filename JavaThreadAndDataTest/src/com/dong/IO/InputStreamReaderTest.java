package com.dong.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

	private File file = new File("E:\\iostudy\\outstreamwriter.txt");
	
	public void read(){
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		try {
			inputStream = new FileInputStream(file);
			inputStreamReader = new InputStreamReader(inputStream);
			char[] str = new char[150];
			inputStreamReader.read(str);
			System.out.println(new String(str));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				inputStreamReader.close();
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		InputStreamReaderTest inputStreamReaderTest = new InputStreamReaderTest();
		inputStreamReaderTest.read();
	}

}
