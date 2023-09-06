package TestPackage;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = new HashMap<>();
		System.out.println(map.containsKey(1)); 
		map.put(1, 1);
		System.out.println(map.containsValue(1));
	}

}
