package helloworld;
import java.util.Arrays;
import java.util.Scanner;
public class ArrayPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr = {1,2,3,4,5};
		String[] names = new String[5];
		Scanner sc = new Scanner(System.in);
//		System.out.println("Input: ");
//		for(int i = 0; i < 1; i++ ) {
//			names[i]  = sc.next();			
//		}
//		System.out.println("Output: ");	
//		for(String n:names) {
//			System.out.println(n);
//		}

		sc.close();
		int[] array = {1,2,3};
		int[] newArray  = Arrays.copyOf(array, 5);
		System.out.println(Arrays.toString(newArray));

	}

	
}
