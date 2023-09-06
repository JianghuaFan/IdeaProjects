package Sort;

public class BubbleSort {
	
	   static void bubbleSort(int[] arr){
		int n = arr.length;
		boolean isSwap = false;
		int position = arr.length - 1;
		int newPosition = 0;
		int j = 0;
		for(int i = 0; i < n-1; i ++) {
			for(j = 0; j < position; j ++) {
				if( arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					isSwap = true;					
					newPosition = j;
				}
				System.out.println("第"+(i+1)+"趟，第"+(j+1)+"次比较后的结果：");
				for(int k = 0; k < n; k++) {
					System.out.print(arr[k]+" ");
				}
				System.out.println();
				
			}
			if(!isSwap) {break;}
			position = newPosition;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BubbleSort ob = new BubbleSort();
		int[] a = {3,6,4,2,1};
		ob.bubbleSort(a);
		//ob.printArr(a);
		//if(j == 0) {break;}
		//bubbleSort(a);
		//printArr(a);
	}	

}
