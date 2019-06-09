package dataStructor.sort;

import java.util.Arrays;

public class QuickSort {
	
	private static int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
	
	//排序函数
	public static void sort(int left, int right) {
		//次部非常重要
		if(left > right) {
			return;
		}
		//哨兵
		int temp = arr[left];
		int i = left;
		int j = right;
	
		
		while(i != j) {
			
			while(arr[j]>=temp && i<j) {
				j--;
			}
			
			while(arr[i]<=temp && i<j) {
				i++;
			}
			
			if(i < j) {
				swap(i, j);
			}
		}
		
		//切换基准
		int datumPoint = arr[i];
		arr[i] = temp;
		arr[left] = datumPoint;
		
		//递归调用
		sort(left, i-1);
		sort(i+1, right);
	}
	
	//交换函数
	public static void swap(int indexa, int indexb) {
		int tmp = arr[indexa];
		arr[indexa] = arr[indexb];
		arr[indexb] = tmp;
	}
	
	public static void main(String[] args) {
		sort(0, 9);
		System.out.println(Arrays.toString(arr));
	}
	
}
