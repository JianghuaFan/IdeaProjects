package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionbyHeight406 {
	public static int[][] reconstructQueue(int[][] people) {
	    if (people == null || people.length == 0 || people[0].length == 0) {
	        return new int[0][0];
	    }
	    Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
	    List<int[]> queue = new ArrayList<>();
	    for (int[] p : people) {
	        queue.add(p[1], p);
	    }
	    return queue.toArray(new int[queue.size()][]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		for (int i = 0; i < people.length; i ++) {
		System.out.print(Arrays.toString(reconstructQueue(people)[i])+" ");
		}
		System.out.println();
		System.out.print(Arrays.deepToString(reconstructQueue(people)));
	}

}
