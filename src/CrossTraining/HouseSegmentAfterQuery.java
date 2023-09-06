package CrossTraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HouseSegmentAfterQuery {
	public List<Integer> segment(List<Integer> house, List<Integer> query){
		List<Integer> res = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		// put value and corresponding index to map
//		for(int i = 0; i< house.size(); i++) {
//			map.put(house.get(i), i);
//		}
		Set<Integer> set = new HashSet<>();
		for(int i : house) {
			set.add(i);
		}
		int segments = getSegment(house);
		// logic is: 
		//case 1: if current query number in the house list has both left and right neighbors
		// the segments would increase by 1
		// case 2: if current query number has only one neighbor, the segments would be same
		// case 3: if current query number has no neighbor, the segments would decrease by 1
		for(int i = 0; i < query.size(); i++) {
//			if(map.containsKey(query.get(i) - 1) && map.containsKey(query.get(i) + 1)) {
//				segments += 1;
//				res.add(segments);
//			}else if (map.containsKey(query.get(i) - 1) || map.containsKey(query.get(i) + 1)) {
//				res.add(segments);
//				continue;
//			}else {
//				segments -= 1;
//				res.add(segments);
//			}
			if(set.contains(query.get(i) - 1) && set.contains(query.get(i) + 1)) {
				segments += 1;
				res.add(segments);
				set.remove(query.get(i));
			}else if (set.contains(query.get(i)+ 1) || set.contains(query.get(i) - 1) || set.contains(query.get(i) + 1)) {
				res.add(segments);
				set.remove(query.get(i));
				continue;
			}else {
				segments -= 1;
				res.add(segments);
				set.remove(query.get(i));
			}
		}		
		return res;
	}
	private int getSegment(List<Integer> house) {
		// TODO Auto-generated method stub
		// calculate the segments of the input list
		int segments = 1;
		for(int i = 1; i < house.size(); i++) {
			if(house.get(i) == house.get(i - 1) + 1) {
				continue;
			}else {
				segments++;
			}
		}
		return segments;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] houses = {1,2,3,7,8,10,11};
//		Integer[] q = {2,10,8};
		Integer[] q = {1,2,3};
//		Integer[] q = {10,11};
		List<Integer> house = Arrays.asList(houses);
		List<Integer> query = Arrays.asList(q);
		
		HouseSegmentAfterQuery segments = new HouseSegmentAfterQuery();
		System.out.println(segments.segment(house, query));
//		System.out.println(house);
//		System.out.println(segments.getSegment(house));
	}

}
