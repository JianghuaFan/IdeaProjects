package Sort;

import java.util.Arrays;

public class ShellSort {
	//初始化划分增量
	static void ShellSort1(int[] arr) {
	int increment = arr.length;
	int temp;
	//每次减小增量，直至increment = 1
	while(increment > 1) {
		//增量的取法之一：除三向下取整
		increment = increment/3 + 1;
		for(int i = increment; i < arr.length; ++i){
				int cur = arr[i];
				int j = i - increment;
				for(; j >= 0 && arr[j] > cur; j -= increment) {
					swap(arr,j,j+1);
				//arr[j+increment] = arr[j];
				}
				//arr[j+increment] = cur;
	    }
	}
	}
	static void swap(int[] arr,int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{2,5,3,45,6,7,43};
		ShellSort1(arr);
		System.out.println(Arrays.toString(arr));

	}

}
