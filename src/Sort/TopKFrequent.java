package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {
	public static int[] topKFrequent(int[] nums, int k) {
		//count the frequency for each element
		Map<Integer,Integer> frequencyForNum = new HashMap<>();
		for(int num: nums){
			frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0)+1);			
		}
		//initialize an array of ArrayList, index is frequency, value is list of numbers
		List<Integer>[] buckets = new ArrayList[nums.length +1];
		for (int key: frequencyForNum.keySet()) {
			int frequency = frequencyForNum.get(key);
			if(buckets[frequency]==null) {
				buckets[frequency]= new ArrayList<>();
			}
			buckets[frequency].add(key);
		}
		//int[] b = new int[5];
		//  输出k个频率最高的数，如果桶为空继续，桶不为空且里面的数的个数小于还可装的个数则全部添加到链表topK里，否则添加还可装的k-topK.size
		List<Integer> topK = new ArrayList<>();
		for(int i = buckets.length -1; i >= 0 && topK.size() < k; i--) {
			if(buckets[i] == null) {
				continue;
			}
			if(buckets[i].size() <= (k - topK.size())) {
				topK.addAll(buckets[i]);
			}else {
				topK.addAll(buckets[i].subList(0,k-topK.size()));
			}
		}
		//add most frequent numbers to result
		int [] res = new int[k];
		for(int i =0; i<k; i++) {
			res[i]= topK.get(i);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,1,2,2,3,3,3};
		int k = 2;
		int[] topK = topKFrequent(arr,k);
		System.out.print(Arrays.toString(topK));

	}

}
