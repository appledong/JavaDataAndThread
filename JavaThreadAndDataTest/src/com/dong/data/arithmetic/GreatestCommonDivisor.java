package com.dong.data.arithmetic;

public class GreatestCommonDivisor {

	/**
	 * 求两个数的最大公约数
	 * 欧几里得算法：两数求于，余数即为两数的最大公约数
	 * 算法分析：两数求于，然后第二个数和余数继续求于直到余数为0然后返回为0前的上一个余数
	 * @param m
	 * @param n
	 * @return
	 */
	public static int gcd(int m, int n) {
		while (n != 0) {
			int rem = m % n;
			m = n;
			n = rem;
		}
		return m;
	}

	public static void main(String[] args) {
		int m = 1432;
		int n = 512;
		System.out.println("m和n的最大公约数是："+gcd(m, n));
	}

}
