package doubleIndex;

import java.util.HashSet;
import java.util.Scanner;

public class SquareSum {
	//判断一个非负整数是否为两个整数的平方和
	
	public static boolean judgeSquareSum(int target){
		 if(target < 0) return false;
	     int sqrt = (int)Math.sqrt(target);
	     for (int i = 0; i <= sqrt; ++i) {
	         int j = (int)Math.round(Math.sqrt(target - i * i));
	         if(target == i * i + j * j)
	             return true;
	      }
	        return false;	        
//		if (target < 0) return false;
//		int i = 0, j = (int)Math.round(Math.sqrt(target));
//		while (i <= j) {
//			int powSum = i*i + j*j;
//			if (powSum < target) {
//				i++;
//			}
//			else if (powSum > target) {
//				j--;
//				}
//			else {
////				(powSum == target) {
//					return true;
//				}
//		}
//		return false;
//		HashSet<Long> nums = new HashSet<>();
//        for (int i = 0; i <= Math.sqrt(target); i ++) {
//            nums.add((long)i*i);
//            if (nums.contains((long)(target - i*i))) {
//                return true;
//            }
//        }
//        return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please input a number to judge if it is a squareSum of two numbers:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(n + "\n");
		if(judgeSquareSum(n) == true) {
			System.out.println("the number you input is a squareSum of two numbers.");
		}
		else {
			System.out.println("the number you input is not a squareSum of two numbers.");
		}
//		System.out.println(Math.sqrt(2147483600));
//		System.out.print((int)Math.round(Math.sqrt(2147483600)));
		
	}

}
