package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class findCommomNumber {
	public List<Integer> common(int[] A, int[] B){
		List<Integer> res = new ArrayList<>();
		if(A == null || B == null){
			return res;
		}
		//	Method 1 : when size of A is similar with size of B 
//		int i = 0;
//		int j = 0;
//		while(i < A.length && j < B.length){
//			if(A[i] == B[j]){
//				res.add(A[i]);
//				i++;
//				j++;
//			}else if (A[i] < B[j]){
//				i++;
//			}else{
//				j++;
//			}			
//		}
		//Method 2: when size of A is far smaller than B (有重复元素未解决)
//		for(int numA : A) {
//			if(binarySearch(B, numA)) {
//				res.add(numA);
//			}
//		}
//		return res;
//	}
//	public boolean binarySearch(int[] B, int numA) {
//		if(numA < B[0] || numA > B[B.length - 1]) {
//			return false;
//		}
//		int left = 0;
//		int right = B.length - 1;
//		while(left <= right) {
//			int mid = left + (right - left) / 2;
//			if(B[mid] == numA) {
//				return true;
//			}else if (B[mid] < numA) {
//				left = mid + 1;
//			}else {
//				right = mid - 1;
//			}
//		}
//		return false;
//		
//	}
		// Method 3: HashSet无法解duplicate 问题
//		Set<Integer> s1 = new HashSet<>();
//		Set<Integer> s2 = new HashSet<>();
//		for(int a : A) {
//			s1.add(a);
//		}
//		for(int b : B) {
//			s2.add(b);
//		}
//		for(int a : A) {
//			if(s2.contains(a)) {
//				res.add(a);
//			}
//		}
//		return res;
		// Method 4: HashMap
		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();
		for(int a : A) {
//			Integer aCount = map1.get(a);
//			if(aCount != null) {
//				map1.put(a, aCount + 1);
//			}else {
//				map1.put(a, 1);
//			}
			map1.put(a, map1.getOrDefault(a,0)+1);
		}
		for(int b : B) {
//			Integer bCount = map2.get(b);
//			if(bCount != null) {
//				map2.put(b, bCount + 1);
//			}else {
//				map2.put(b, 1);
//			}	
			map2.put(b, map2.getOrDefault(b,0)+1);
		}
		for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {			 
//			int aCount = map1.get(entry.getKey());
//			if(map2.containsKey(entry.getKey())) {
//				int bCount = map2.get(entry.getKey());				
//				for(int i = 0; i < Math.min(aCount, bCount); i++) {
//					res.add(entry.getKey());
//				}				
//			}	
			Integer bCount = map2.get(entry.getKey());
			if(bCount != null) {
				for(int i = 0; i < Math.min(map1.get(entry.getKey()), bCount); i++) {
					res.add(entry.getKey());
				}
			}
		}
		return res;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = {1, 1, 2, 3};
		int[] B = {1, 1, 2, 2, 5, 6};
		findCommomNumber find = new findCommomNumber();
		System.out.print(find.common(A, B));
		
	}

}
