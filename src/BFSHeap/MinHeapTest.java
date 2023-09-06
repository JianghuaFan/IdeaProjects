package BFSHeap;

public class MinHeapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {10,1,2,3};
		MinHeap minHeap = new MinHeap(array);
//		int pollNumber = minHeap.poll();
//		System.out.println("pollNumber:" + pollNumber);
		System.out.println("Is minHeap empty:" + minHeap.isEmpty());
		while(!minHeap.isEmpty()) {
			System.out.println( minHeap.poll() + "," );
		}
	}

}
