package BinarySearch;

import java.util.Dictionary;

public class SearchInUnknownSizedSortedArray {
	public int search(Dictionary1 dict, int target) {
		if(dict == null) {
			return -1;
		}
		int left = 0;
		int right = 1;
		while(dict.get(right) != null && dict.get(right) < target) {
			left = right;
			right = right * 2;
		}
		return binarySearch(dict, target, left, right);
	}
	public int binarySearch(Dictionary1 dict, int target, int left, int right) {
		int start = left;
		int end = right;
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(dict.get(mid) != null && dict.get(mid) == target) {
				return mid;
			}else if(get(mid) < target) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		return -1;
		
	}
	
	public Integer get(int key) {
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		for(int i = 0; i < array.length; i++) {
			if(array[i] == key) {
				return i;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInUnknownSizedSortedArray search = new SearchInUnknownSizedSortedArray();
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		Dictionary1 d = new Dictionary1(array);
		System.out.print(search.search(d, 3));
		

	}

}
