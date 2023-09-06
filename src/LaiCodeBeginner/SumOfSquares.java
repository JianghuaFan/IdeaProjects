package LaiCodeBeginner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfSquares {
	public static int sumOfSquare(List<Integer> list) {
		if (list == null || (list.isEmpty()))
		      return 0;

		int sum = 0;
//		for (int i : list ) {
//			sum += i * i;
//		}
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i) * list.get(i);
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Integer> list = new ArrayList<>();
		 list.add(1);
		 list.add(2);
		 list.add(3);
		 System.out.print(sumOfSquare(list));

	}

}
