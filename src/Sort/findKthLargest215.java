package Sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class findKthLargest215 {
	public static int findKthLargestSort(int[] nums, int k) {
		/*Arrays.sort(nums);
		return nums[nums.length -k];
		*/
		k= nums.length - k;
		int l = 0, h= nums.length-1;
		while(l<h) {
			int pivot = partition(nums,l,h);
			if(pivot == k) {
				break;
				}			
			else if(pivot < k) {
				l = pivot + 1;
				}
			else {
				h = pivot - 1;
				}
		}
			return nums[k];
	}
	public static int partition(int[] a, int l, int h) {
		int i = l, j = h;
		while(true) {
			//a[l]:pivot
			while(a[i]<a[l]&& i<h) {
				i++;
				}
			while(a[j]>a[l]&& j>l) {
				j--;
			}
			if(i>=j) {
				break;
			}
			swap(a,i,j);			
		}
		swap(a,l,i);
		return i;
	}
	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	/*public static int findKthLargestHeap(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int val : nums) {
			pq.add(val);
			if(pq.size()>k)
				pq.poll();
		}
		return pq.peek();
	}
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {2,1,3,0,5};
		int k = findKthLargestSort(nums,3);
		//int k = findKthLargestHeap(nums,3);
		System.out.print(k);
	}

}
