package TestPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewStringReason {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = new ArrayList<>();
		List<List<Integer>> resForNew = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		
		cur.add(1);
		cur.add(2);
		cur.add(3);
		
		res.add(cur);
//		res.add(cur);
		
		resForNew.add(new ArrayList<>(cur));
//		resForNew.add(new ArrayList<>(cur));
		
		System.out.println("res:" + res);
		System.out.println("resForNew:" + resForNew);
		
		cur.remove(cur.size() - 1);
		System.out.println("res:" + res);
		System.out.println("resForNew:" + resForNew);
		StringBuilder sb = new StringBuilder();
		sb.append("a");
		System.out.println("sb before delete:" + sb);
//		sb.delete(0, 1);
		sb.deleteCharAt(0);
		System.out.println("sb after delete:" + sb);
		
		char[] array = {'a', 'b','c'};
		System.out.print("array:" + Arrays.toString(array));

		

	}

}
