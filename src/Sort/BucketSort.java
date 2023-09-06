package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BucketSort {
	public static void BucketSort1(int[] arr) {
		int index = 0;
		//1、遍历数组找到原数组最大值
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		//2、根据步骤一中最大数值创建桶数组，
		//int[] bucketArray = new int[max+1];
		List<Integer> buckets = new ArrayList<>(max+1);
		//3、再次遍历原数组，依次装入桶中
		/*for(int i = 0; i < arr.length; i++) {
			bucketArray[arr[i]]++;
		}*/
		 List<Integer> originList = Arrays.stream(arr).boxed().collect(Collectors.toList());
		 
		for(int i = 0; i < max+1; i++) {
			//buckets.addAll(originList);
			buckets.add(arr[i]);
			//buckets.add(new ArrayList<Integer>());
		}
		//4、输出原数组
		/*for(int i = 0; i < bucketArray.length; i++) {
			for(int j = 0; j < bucketArray[i]; j++) {
				arr[index++] = i;
			}
		}	*/
		for(int i = 0; i < max + 1; i++) {
			for(int j = 0; j < i; j++) {
				arr[index++] = i;
			}
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		//int[] intArr = new int[] {1,2,3};
		int[] arr = new int[] {0,1,0,4,2,0};
		BucketSort1(arr);
		/*for(int i = 0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}*/
		System.out.print(Arrays.toString(arr));

	}

}
