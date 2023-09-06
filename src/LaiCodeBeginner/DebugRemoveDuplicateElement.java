package LaiCodeBeginner;
import java.util.Random;

public class DebugRemoveDuplicateElement {
	public static int[] removeDuplicate(int[] array, int duplicate) {
		   if (array == null || array.length == 0)
		    return array;

		   int count = 0;
		   for (int i = 0; i < array.length; i++) {
		     if (array[i] == duplicate) {
		       count++;
		     }
		   }
		   int n = array.length - count;
		   int[] result = new int[n];
		   int i = 0;
		   int j = 0;
		   while (i < array.length) {
		     if (array[i] == duplicate) {
		       i++;
		     } else {
		       result[j] = array[i];
		       i++;
		       j++;
		     }
		   }
		   return result;
		 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {78,32,31,78};
		System.out.print(removeDuplicate(nums,78));
		double a = Math.random();
		Random random = new Random();
	}

}
