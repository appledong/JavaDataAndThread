package com.dong.data.algorithm;

public class SortAlgorithm {

	/**
	 * 选择排序 原理：第一趟排序获取到最小数，第二趟排序获取到次小数以此类推。 时间复杂度：0+1+....+(n-1),
	 * 即当n为奇数的时候复杂度是n*(n-1)/2 当n为偶数的时候复杂度是(n-1)^2/2+n/2 所以冒泡排序的复杂度接近于你n^2/2
	 * 代码记忆：每趟选出最小数所以需要选择n-1趟，最后一趟不需要选择，每趟比较都是i和i后面的数据比较，所以第二个循环是i+1开始到length
	 * 使用场景：
	 * 
	 * @param numbers
	 */
	public int sort1(int[] numbers) {
		int count = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				count++;
				int temp = 0;
				if (numbers[i] > numbers[j]) {
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		return count;
	}

	public int sort2count = 0;

	/**
	 * 快速排序 原理：选择第一个一个item（最后一个为item）作为基准值，比其大的放到一边比其小的放到一边分为两边继续进行快速排序直到最终完成
	 * 此时时间复杂度16，比冒泡和选择快 代码记忆：递归，基准值，高开低走，低开高走，高补基准，低补高
	 * 
	 * @param numbers
	 */
	public void sort2(int[] numbers, int low, int high) {
		if (low < high) {
			int mid = getMiddle(numbers, low, high);
			sort2(numbers, low, mid - 1);
			sort2(numbers, mid + 1, high);
		}
	}

	private int getMiddle(int[] numbers, int low, int high) {
		int temp = numbers[low];
		while (low < high) {
			/***
			 * 如果选择第一个为基准，那么必须从高位开始 如果选择最后一个为基准，那么必须从低位开始 不然基准值来回的比较出现死循环
			 */
			while (low < high && numbers[high] > temp) {
				sort2count++;
				high--;
			}
			numbers[low] = numbers[high];
			while (low < high && numbers[low] < temp) {
				sort2count++;
				low++;
			}
			numbers[high] = numbers[low];
			// sort2count++;
		}
		numbers[low] = temp;
		return low;
	}

	/**
	 * 冒泡排序 原理：相近的两个数比较，大的数下沉小的数上浮
	 * 代码记忆：一趟排序后会找到最大的值，然后最大的值不在需要比较最多需要n-1趟冒泡每次冒泡比较的个数是n-1-i（i是冒泡的趟数）
	 * 时间复杂度：和选择排序的时间复杂度相同
	 * 
	 * @param numbers
	 */
	public int sort3(int[] numbers) {
		int count = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = 0; j < numbers.length - i - 1; j++) {
				count++;
				if (numbers[j] > numbers[j + 1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
		return count;
	}

	/**
	 * 冒泡排序(增强版) 添加一个boolean值的标识符，待有一趟比较排序没有交换就说明已经完成排序，没有必要再去比较
	 * 
	 * @param numbers
	 */
	public int sort3plus(int[] numbers) {
		int count = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			boolean isExchage = false;
			for (int j = 0; j < numbers.length - i - 1; j++) {
				count++;
				if (numbers[j] > numbers[j + 1]) {
					isExchage = true;
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
			if (!isExchage) {
				break;
			}
		}
		return count;
	}

	/**
	 * 插入排序 原理：第一个值作为已排序的，每一趟排序对应的item都和前面的item比较一遍，小于就前提
	 * 代码记忆：
	 * @param numbers
	 */
	public void sort4(int[] numbers) {
		for (int i = 1; i < numbers.length; i++) {
			for (int j = i; j > 0; j--) {
				if (numbers[j] < numbers[j - 1]) {
					int temp = numbers[j - 1];
					numbers[j - 1] = numbers[j];
					numbers[j] = temp;
				} else{
					break;
				}
			}
		}
	}

	/**
	 * 归并排序
	 * 
	 * @param numbers
	 */
	public void sort5(int[] numbers) {

	}

	public static void main(String[] args) {
		SortAlgorithm sortAlgorithm = new SortAlgorithm();
		int[] numbers = new int[] { 5,3,15,25,18,9,13 };
//		int count = sortAlgorithm.sort1(numbers);
//		System.out.println("选择排序后的统计值是：" + count);
//		for (int value : numbers) {
//			System.out.println("选择排序后的值为：" + value);
//		}
		// int count = sortAlgorithm.sort3plus(numbers);
		// System.out.println("冒泡排序后的统计值是：" + count);
		// for (int value : numbers) {
		// System.out.println("冒泡排序后的值为：" + value);
		// }
//		sortAlgorithm.sort2(numbers, 0, numbers.length - 1);
		// System.out.println("快速排序后的统计值是：" + sortAlgorithm.sort2count);
		// for (int value : numbers) {
		// System.out.println("快速排序后的值为：" + value);
		// }
		
		// System.out.println("快速排序后的统计值是：" + sortAlgorithm.sort2count);
		sortAlgorithm.sort4(numbers);
		for (int value : numbers) {
			System.out.println("快速排序后的值为：" + value);
		}
	}

}
