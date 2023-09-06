package LaiCodeBeginner;

import java.util.Arrays;

public class PerfectShuffle108 {
	public void shuffle(int[] array) {
		   // Write your solution here.
		if(array == null || array.length ==0){
			return;
		}
//		Random rand = new Random(); 
		for(int i = array.length - 1; i >= 0; i--){
//			int j = rand.nextInt(i+1);
			double rand = Math.random();
			int j = (int)(rand*(i+1));
			swap(array, i, j);
			System.out.println("i: " + i);
			System.out.println("rand: " + rand);
			System.out.println("j: " + j);
			System.out.println(Arrays.toString(array));	
			}
			
		}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PerfectShuffle108 shuffle = new PerfectShuffle108();
		
		int[] array = {2,4,3,1};
		shuffle.shuffle(array);
	}

}
