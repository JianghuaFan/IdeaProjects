package TestPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;


public class Test {
	public List<String> test(String set) {
		List<String> res = new ArrayList<>();
		if(set == null) {
			System.out.println("res.size():" + res.size());
			return res;
		}
		if(set.length() == 0) {
			res.add("");
			System.out.println("res.size():" + res.size());
			return res;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>( new Comparator<Integer>(){
			@Override
			public int compare(Integer i1, Integer i2){
				if(i1 == i2){
					System.out.println("Integer same:");
					return 0;					
				}
				return i1 < i2 ? -1 : 1;	
	}
	});

		
//		queue.offer(1);
//		Deque<Integer> dequeInteger = new LinkedList<>();			
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append("a");
//		System.out.println(sb);
//		sb.insert(1,"bcdef");
//		System.out.println(sb);
//		sb.delete(0, 3);
//		System.out.println(sb);
//		Test test = new Test();
//		System.out.println(test.test(null));
//		System.out.println(test.test(""));
//		char[] ch = {'a','b','c'};
//		String str = new String("abc");
//		System.out.println("str1:" + str);
//		str = new String(ch);
//		System.out.println("str2Arrays.toString:" + Arrays.toString(ch));
//		System.out.println("str2NewString(char[] ch):" + new String(ch));
//		
//		String str1= "abc";
//		str.equals("a");
//		LinkedList<Integer> l1 = new LinkedList<>();
//		l1.add(5);
//		l1.add(10);
//		ArrayList<Integer> l2 = new ArrayList<>();
//		l2.add(5);
//		l2.add(10);
//		System.out.println("l1.equals(l2):" + l1.equals(l2));
//		Map<LinkedList,Integer> m1 = new HashMap<>();
//		m1.put(l1,1);
//		Map<ArrayList,Integer> m2 = new HashMap<>();
//		m2.put(l2, 1);
//		System.out.println("m1.equals(m2):" + m1.equals(m2));
//		Map.Entry<LinkedList,Integer> map;
		
		
		
		
	}

}
