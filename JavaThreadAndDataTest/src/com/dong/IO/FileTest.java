package com.dong.IO;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public void createMir(String mirName) {
		if (!"".equals(mirName)) {
			/**
			 * "../../../../" + mirName：相对路径的写法，当前的主盘符下创建文件夹 "." +
			 * mirName:没有意义，.相当于文件名 "/" + mirName:代表当前项目所在的主盘符root目录下创建文件夹 "./"
			 * + mirName：相当于项目的根目录（Root目录） "F/" + mirName：F被看作一个文件夹名字
			 * "E:/Androiddemo/iostudy"：绝对路径的写法
			 */
			File file = new File("E:/" + mirName);
			System.out.println("当前路径是：" + file.getAbsolutePath());
			System.out.println("当前file是否被隐藏：" + file.isHidden());
			if (file != null) {
				if (!file.exists()) {
					System.out.println("当前目录是否创建成功：" + file.mkdirs());
					/*
					 * if (file.isDirectory()) {//
					 * isFile,isDirectory:当前file存在且是一个目录返回true，不然始终是false
					 * 
					 * } else { throw new NullPointerException("file不是目录"); }
					 */
				} else {
					System.out.println("file文件夹已存在");
				}
			}
		}
	}

	/**
	 * 判断传入的path是不是绝对路径
	 * 
	 * @param path
	 * @return
	 */
	public boolean isAbsolutePath(String path) {
		File file = new File(path);
		System.out.println("当前路径是：" + file.getAbsolutePath());
		return file.isAbsolute();
	}

	/**
	 * 判断传入的file是否已经存在
	 * 
	 * @param path
	 * @return
	 */
	public boolean isExists(String path) {
		File file = new File(path);
		return file.exists();
	}

	public void createNewFile(String path) {
		File file = new File("E:/" + path);
		System.out.println("当前路径是：" + file.getAbsolutePath());
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteFile(String path) {
		File file = new File("E:/" + path);
		if (file.exists()) {
			file.delete();
		}
	}

	/**
	 * 遍历给定文件夹下的文件（子文件夹也是文件处理）
	 * 返回的类型是文件的名字
	 * @param path
	 */
	public void listFile(String path) {
		File file = new File(path);
		if (file.exists()) {
			String[] files = file.list();
			if (files != null && files.length > 0) {
				for (String file2 : files) {
					System.out.println("当前文件夹下文件的路径是：" + file2);
				}
			}
		}
	}
	
	/**
	 * 遍历给定文件夹下的文件（子文件夹也是文件处理）
	 * 返回的类型是文件file（内部包含绝对路径）
	 * @param path
	 */
	public void listFiles(String path) {
		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files != null && files.length > 0) {
				for (File file2 : files) {
					try {
						System.out.println("当前文件夹下文件的路径是2：" + file2.getCanonicalPath());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void listRoot(String path){
		File file = new File(path);
		File[] files = file.listRoots();
		for (File file2 : files) {
			System.out.println("Root下文件的路径是：" + file2.getAbsolutePath());
		}
	}

	public static void main(String[] args) {
		String mirPath = "iostudy/";
		FileTest fileTest = new FileTest();
		fileTest.createMir(mirPath);
		fileTest.createNewFile(mirPath + "newfile.txt");
		fileTest.deleteFile(mirPath + "newfile.txt");
		fileTest.createNewFile(mirPath + "newfile.txt");
		fileTest.listFile("E:\\Androiddemo");
		fileTest.listFiles("E:\\Androiddemo");
		fileTest.listRoot("E:\\Androiddemo");
		File file = new File("E:\\Androiddemo");
		System.out.println("总的容量是多少："+file.getTotalSpace()/1000/1000/1000);
		System.out.println("空闲容量是多少："+file.getFreeSpace()/1000/1000/1000);
		System.out.println("还可以使用的容量是多少："+file.getUsableSpace()/1000/1000/1000);
		// System.out.println("F:\\Deskto是不是绝对路径：" +
		// fileTest.isAbsolutePath("F:\\Deskto"));
		// System.out.println("F:\\Desktop是不是已经存在：" +
		// fileTest.isExists("F:\\Desktop"));

	}
}
