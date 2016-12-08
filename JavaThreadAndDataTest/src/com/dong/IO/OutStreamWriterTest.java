package com.dong.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * 
 * @author dong
 * 
 */
public class OutStreamWriterTest {

	private File file = new File("E:\\iostudy\\outstreamwriter.txt");

	public void write() {
		OutputStream outputStream = null;
		OutputStreamWriter outWriter = null;
		try {
			outputStream = new FileOutputStream(file);
			/**
			 * FileWriter就是封装的FileOutputStream
			 */
			outWriter = new OutputStreamWriter(outputStream);
			String str = "bytestream convert charstream write data";
			outWriter.write(str);
			outWriter.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				outWriter.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		OutStreamWriterTest outStreamWriterTest = new OutStreamWriterTest();
		outStreamWriterTest.write();
	}

}
