package com.dong.network;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CharCoding {

	public static void main(String[] args) {
		System.out.println("中国很美好");
		// InputStream is = null;
		// try {
		// is = new FileInputStream(new File(""));
		// } catch (Exception e) {
		// e.printStackTrace();
		// } finally {
		// if (is != null) {
		// try {
		// is.close();
		// } catch (IOException e1) {
		// e1.printStackTrace();
		// }
		// }
		// }
		//
		// try (OutputStream outputStream = new FileOutputStream(new File(""))){
		// // outputStream.write(b);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		InputStream is = null;
		try {
			// is = new FileInputStream(new File(""));
			// is = new BufferedInputStream(is);
			// is = new DataInputStream(is);
			is = new DataInputStream(new BufferedInputStream(
					new FileInputStream(new File(""))));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
