package com.dong.NIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 针对过G的大文件nio的效率高于io，对于普通文件io的效率高于nio
 * @author dong
 *
 */
public class MappedByteBufferTest {

	String readPath = "E:\\niostudy\\19113.exe";
	String nIOWritePath = "E:\\niostudy\\nio19113.exe";
	String ioWritePath = "E:\\niostudy\\io19113.exe";

	public void iotest() {
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			long starttime = System.currentTimeMillis();
			inputStream = new FileInputStream(new File(readPath));
			outputStream = new FileOutputStream(new File(ioWritePath));
			byte[] is = new byte[1024 * 10];
			while (inputStream.read(is) != -1) {
				outputStream.write(is);
			}
			long writetime = System.currentTimeMillis();
			System.out.println("io write file time:" + (writetime - starttime));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void niotest() {
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		FileChannel isChannel = null;
		FileChannel outChannel = null;
		try {
			long starttime = System.currentTimeMillis();
			inputStream = new FileInputStream(new File(readPath));
			outputStream = new FileOutputStream(new File(nIOWritePath));
			isChannel = inputStream.getChannel();
			outChannel = outputStream.getChannel();
			ByteBuffer bb = ByteBuffer.allocate(1024 * 10);
			bb.clear();
			while (isChannel.read(bb) != -1) {
				bb.flip();
				outChannel.write(bb);
				// outChannel.force(true);
				bb.clear();
			}
			long endtime = System.currentTimeMillis();
			System.out.println("nio花费的时间是：" + (endtime - starttime));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				isChannel.close();
				outChannel.close();
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		MappedByteBufferTest moBufferTest = new MappedByteBufferTest();
		moBufferTest.iotest();
		moBufferTest.niotest();
	}

}
