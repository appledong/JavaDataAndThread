package com.dong.IO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public void write() {
		File file = new File("E:\\iostudy\\randomaccessfile.txt");
//		if (!file.exists()) {
			try {
//				file.createNewFile();
				RandomAccessFile radf = new RandomAccessFile(file, "w");
				String name1 = "李明";
				int age1 = 18;
				String name2 = "张华";
				int age2 = 19;
				radf.write(name1.getBytes());
				radf.writeInt(age1);
				radf.write(name2.getBytes());
				radf.writeInt(age2);
				radf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
//		}
	}

	public void read() {
		File file = new File("E:\\iostudy\\randomaccessfile.txt");
//		if (file.exists()) {
			try {
				RandomAccessFile radf = new RandomAccessFile(file, "rw");
				radf.skipBytes(10);
				// 读取第二个姓名和年龄
				byte[] bname2 = new byte[6];
				radf.read(bname2);
				String name2 = new String(bname2);
				int age2 = radf.readInt();
				System.out.println("存入第二个孩子的信息是：name2：" + name2 + "age2:"
						+ age2);
				radf.seek(0);
				// 读取第一个姓名和年龄
				byte[] bname1 = new byte[6];
				radf.read(bname1);
				String name1 = new String(bname1);
				int age1 = radf.readInt();
				System.out.println("存入第二个孩子的信息是：name1：" + name1 + "age1:"
						+ age1);
				radf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
//		}
	}

	public static void main(String[] args) {
		RandomAccessFileTest randomAccessFileTest = new RandomAccessFileTest();
//		randomAccessFileTest.write();
		randomAccessFileTest.read();
	}

}
