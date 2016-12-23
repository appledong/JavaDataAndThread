package com.dong.NIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferTest {

	public void createMir() {
		File file = new File("E:\\niostudy");
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	public void write() {
		FileOutputStream outputStream = null;
		FileChannel channel = null;
		try {
			outputStream = new FileOutputStream(new File(
					"E:\\niostudy\\channelbuffertest.txt"));
			channel = outputStream.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			// buffer.limit(2);
			buffer.put("test nio channel buffer write a lot data,test"
					.getBytes());
			buffer.flip();
			channel.write(buffer);
			/**
			 * channel是双向的，但是依赖于stream，一个通道只能做读或者写
			 */
			// ByteBuffer buffer2 = ByteBuffer.allocate(1024);
			// channel.read(buffer2);
			// System.out.println(new String(buffer2.array()));
			// channel.write(ByteBuffer.wrap("test nio channel buffer write a lot data,test".getBytes()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				channel.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 从一个File转移到另一个File。
	 */
	public void write2() {
		FileOutputStream outputStream = null;
		FileInputStream inputStream = null;
		FileChannel channel = null;
		FileChannel inputChannel = null;
		try {
			inputStream = new FileInputStream(new File(""));
			inputChannel = inputStream.getChannel();
			outputStream = new FileOutputStream(new File(
					"E:\\niostudy\\channelbuffertest.txt"));
			channel = outputStream.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			buffer.clear();
			while (inputChannel.read(buffer) != -1) {
				buffer.flip();
				channel.write(buffer);
				buffer.clear();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				channel.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void read() {
		FileInputStream inputStream = null;
		FileChannel channel = null;
		try {
			inputStream = new FileInputStream(new File(
					"E:\\niostudy\\channelbuffertest.txt"));
			channel = inputStream.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			channel.read(buffer);
			// System.out.println(buffer.toString());
			// buffer.flip();
			// Charset cs = Charset.defaultCharset();
			// System.out.println(cs.decode(buffer));
			System.out.println(new String(buffer.array()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				channel.close();
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ChannelBufferTest channelBufferTest = new ChannelBufferTest();
		channelBufferTest.createMir();
		channelBufferTest.write();
		// channelBufferTest.read();
	}

}
