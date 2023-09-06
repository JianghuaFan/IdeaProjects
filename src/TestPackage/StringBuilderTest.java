package TestPackage;

import java.util.ArrayList;
import java.util.List;

public class StringBuilderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append('a').append('b');
		System.out.println(sb.toString());
		sb.setLength(1);
		System.out.println("after setLength:"+sb.toString());
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		System.out.println(list);
		list.subList(0, 2).clear();
		System.out.println("after subList clear:" + list);
	}

}
