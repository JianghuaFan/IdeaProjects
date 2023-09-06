package BFSHeap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;



public class KthSmallestInUnsortedArray {
	public int[] kthSmallest(int[] array, int k) {
		if(array == null || array.length == 0 || array.length < k)
			return array;
		if(k == 0)
			return new int[0];
		int[] res = new int[k];
		//minHeap
//		List<Integer> list = new ArrayList<>();
//		for(int i : array) {
//			list.add(i);
//		}
//		
//		PriorityQueue<Integer> minHeap = new PriorityQueue<>(list);
//		for(int i = 0; i < k; i++) {
//			res[i] = minHeap.poll();
//		}
//		return res;
		
		// maxHeap
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k,new Comparator<Integer>() {
			@Override 
			public int compare(Integer a, Integer b) {
				if(a.equals(b))
					return 0;
				return a > b ? -1 : 1;				
			} 
		});
		for(int i = 0; i < array.length; i++) {
			if(i < k) {
				maxHeap.offer(array[i]);
			}else {
				if(array[i] < maxHeap.peek()) {
					maxHeap.poll();
					maxHeap.offer(array[i]);
				}
			}
		}
		for(int i = k-1; i >= 0; i--) {
			res[i] = maxHeap.poll();
		}
		return res;
	
	}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		if(array == null || array.length == 0 || array.length < k)
//			return array;
//		int[] res = new int[k];
//		List<Integer> list = new ArrayList<>();		
//		for(int i : array) {
//			list.add(i);
//		}
//		PriorityQueue<Integer> minHeap = new PriorityQueue<>(list);
//		for(int i = 0; i < k; i++) {
//			res[i] = minHeap.poll();
//		}		
//		return res;
//		if(k == 0) {
//		      return new int[0];
//		    }
//		    int[] res = new int[k];
//		    List<Integer> list = new ArrayList<>();
//		   
////		    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k,new Comparator<Integer>() {
////		    	@Override 
////		        public int compare( Integer i1, Integer i2){
////		          if(i1.equals(i2)) return 0;
////		          return i1 > i2 ? -1 : 1;
////		        }
////		    });
//		    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k,(Integer i1, Integer i2) -> {
//		    	if(i1.equals(i2)) return 0;
//		    	return i1 > i2 ? -1 : 1;
//		    });
//		    for (int i = 0; i < k; i++) {
//		    	maxHeap.offer(array[i]);
//		    }
//		    for (int i = k; i < array.length; i++) {
//		    	if(array[i] < maxHeap.peek()) {
//		    		maxHeap.poll();
//		    		maxHeap.offer(array[i]);
//		    	}
//		    }
//		    for(int i = 0; i < k; i++) {
//		    	list.add(maxHeap.poll());
//		    }
//		    Collections.reverse(list);
//		    for(int i = 0; i < k; i++) {
//		    	res[i] = list.get(i);
//		    }
//		    return res;	
//		if(k == 0) {
//		      return new int[0];
//		    } 
//		int[] res = new int[k];
//		    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
//		      @Override
//		      public int compare(Integer i1, Integer i2) {
//		        if (i1.equals(i2)) return 0;
//		        return i1 > i2 ? -1 : 1;
//		      }
//		    });
//		    for (int i = 0; i < array.length; i++) {
//		      if (i < k) {
//		        maxHeap.offer(array[i]);
//		      }else {
//		        if(array[i] < maxHeap.peek()) {
//		          maxHeap.poll();
//		          maxHeap.offer(array[i]);
//		        }
//		      }
//		    }
//		    for (int i = k-1; i >=0; i--) {
//		      res[i] = maxHeap.poll();
//		    }
//		    return res;
//
//	}
//	  private static class Mycomparator implements Comparator<Integer>{
//      @Override 
//      public int compare( Integer i1, Integer i2){
//        if(i1.equals(i2)) return 0;
//        return i1 > i2 ? -1 : 1;
//      }
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		KthSmallestInUnsortedArray kth = new KthSmallestInUnsortedArray();
		
		int[] array = {10,8,6,4,2,1,3,5,7,9,};
		System.out.print(Arrays.toString(kth.kthSmallest(array, 3)));

	}

}
