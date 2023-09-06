package TestPackage;
// List的实现类
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.HashSet;


//Set的实现类
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;
//Map的实现类
import java.util.Map;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;




public class TestSet {
        @SuppressWarnings("deprecation")
        public void print() {
        	System.out.println("test");
        }
        
        
	public static void main(String[] args) {
		TestSet se = new TestSet();
		se.print();
		// TODO Auto-generated method stub	
		Set<Integer> t1 = new HashSet<Integer>();
		HashSet<Character> a = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
		//System.out.println(a);
		final HashSet<Character> vowels = new HashSet<>(
				Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
		Set<Integer> t2 = new TreeSet<Integer>();// Tree set assort the elements in the set
		//t2.add(null);
		Set<Integer> t3 = new LinkedHashSet<Integer>();
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		LinkedList<Integer> a2 = new LinkedList<Integer>();
		HashSet<String> set = new HashSet<>();
		set.add(null);
		//Assert.assertEquals(1, set.size());
		set.add(null);
		//Assert.assertEquals(2, set.size());
		System.out.println(set);
		Map m1 = new HashMap();
		Map m2 = new TreeMap();
		Map m3 = new LinkedHashMap();
	
		Map<Integer,Integer> m4 = new HashMap<>();
		a1.add(3);
		a1.get(0);
		a1.add(4);
		a1.set(0, null);
		a2.add(3);
		a2.add(4);
		t3.add(3);
		t3.add(2);
		t3.add(4);
		t3.add(-5);
		m1.put("t1m",1);
		m1.put("t2m",2);
		m1.put("t3m",3);
		System.out.println(m2.getClass());
		
		System.out.println(m1.get("t1m"));

		//System.out.println(m1.get("t1m"));
		//System.out.println(m1.containsValue(1));
		//System.out.println(m1.keySet());
		System.out.println(m1.toString());
		System.out.println(m1.entrySet());
		boolean b = t3.contains(3);
		int s = t3.size();
		//System.out.print(a2);
		String s1 = "hello";
		String s2 = new String("hello");
		s2 = s1.intern();
		if(s1 == s2) {
			//System.out.print(1);
		}
		else{
			System.out.print(2);			
		}
		
	Set<Integer>[] set1 = new HashSet[2];
	set1[0] = new HashSet<>();
	set1[1] = new HashSet<>();
	set1[0].add(5);
	set1[1].add(2);
	for(Set setExample : set1) {
		System.out.print(setExample);
	}
}
}



