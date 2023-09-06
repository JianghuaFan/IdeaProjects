package Sort;

import java.util.Arrays;

public class InsertionBinarySort {
	public static void InsertBinarySort(int[] arr) { 
	int i, j, low,high,cur;
	for( i = 1; i < arr.length; i++) {
		low = 0; 
		high = i-1;		
		cur = arr[i];
		/*找到合适的插入位置high+1， 如果中间位置元素比要插入的元素大，
		 * 则查找区域向低半区移动，否则向高半区移动
		 */
		while(low <= high) {
			int mid = (low + high)/2;
			if(cur < arr[mid]) {
				high = mid -1;
			}
			else  {
				low = mid+1;
			}
			System.out.println("mid:"+mid);
		}
		for( j = i-1; j >= high+1; j--) {
			swap(arr,j+1,j);
			//arr[j+1] = arr[j];
			System.out.println(" ja:"+j);
		}
		//arr[j+1] = cur;
		System.out.println(" i:"+i +" jb:"+j+" low:"+low+" high:"+high);
		System.out.println(cur);
		//System.out.println("high:"+high);
		System.out.print(Arrays.toString(arr));
		System.out.println();
	}
}
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr [j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {3,5,2,6,1,6};
		InsertBinarySort(arr);
		System.out.print(Arrays.toString(arr));

	}

}
