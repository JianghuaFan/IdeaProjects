package TestPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<List<Integer>> listList = new ArrayList<>();
		list.add(1);
		list.add(2);
		list2.add(3);
		list2.add(4);
		listList.add(list);
		listList.add(list2);
		listList.add(2, list2);		
		listList.add(3, Arrays.asList(5,6));
//		listList.add(0,Arrays.binarySearch(array, target));
//		System.out.println("array: " + Arrays.toString(array));
//		System.out.println("list: " + list);
//		System.out.println("listList: " + listList);
		Map<Integer, List<Integer>> map = new HashMap<>();
		System.out.println("map: " + map);
		map.put(1, new ArrayList<>(Arrays.asList(1)));
		System.out.println("map: " + map);
		 
		    Class c1 = list.getClass();
		    List<String> list3 = new ArrayList<>();
		    Class c3 = list3.getClass();
		    System.out.println(c1 == c3);
		    System.out.println(c1);
		    System.out.println(c3);
		    		    
	}

}
