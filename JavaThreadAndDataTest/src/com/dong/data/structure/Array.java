package com.dong.data.structure;

public class Array {
	
	public static void arrayExtends(){
		int[] array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		int[] extendsArray = new int[15];
		for (int i = 0; i < array.length; i++) {
			extendsArray[i] = array[i];
		}
		array = extendsArray;
		for (int i : array) {
			System.out.println("当前数是"+i);
		}
	}

	public static void main(String[] args) {
		arrayExtends();
	}

}
