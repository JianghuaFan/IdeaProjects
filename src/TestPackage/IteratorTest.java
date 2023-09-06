package TestPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest<E> {
	String IteratorTestName;

	class ListIter1{
		String owner = IteratorTestName;
		int next() {
			return 0;
		}
		boolean hasNext(){
			return false;
		}
//		ListIter1(){
//			
//		}// 可以没有构造器，系统给配置默认的
	}
	static class ListIter2NestedClass{
		ArrayList<Integer> list;
//		ListIter2(){
//			
//		}
		ListIter2NestedClass(ArrayList<Integer> list){
			this.list = list;
		}// 可以没有构造器，系统给配置默认的，但是一旦定义了构造器，新建对象时必须传入参数，没有参数也要在参数括号里写明null
	}
	
	public static  <E> void main(String[] args) {
		// TODO Auto-generated method stub
		
		IteratorTest.ListIter1 listIter1 =  new IteratorTest<E>().new ListIter1();
		IteratorTest.ListIter2NestedClass listNestedStatic = new IteratorTest.ListIter2NestedClass(null);
		
		List<Integer> list = new ArrayList<>();		
		for(int i = 0; i < 10; i++) {
			list.add(i);			
		}
		for(int i = 0; i < 10; i++) {
			list.remove(i);			
		}
		
//		Iterator<Integer> it = list.iterator();
//		System.out.println(it.next().intValue());
//		while(it.hasNext()) {
//			try{
//				it.next();
//			}
//			catch(NullPointerException ex) {
//				System.out.println("Exception ex caught");
//			}
//			System.out.print(it.next().intValue());			
//
////			list.remove(it.next());//java.util.ConcurrentModificationException
//		}
	}

}
