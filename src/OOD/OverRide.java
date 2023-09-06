package OOD;
public class OverRide {
	public class A {
	    private void print() {
	        System.out.println("A");
	    }	    
	}

	class B extends A {
	    public void print() {    
	        System.out.println("B");
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		在Java中，所有的private方法默认是final的，即不可继承的。所以当B继承A时，A的private方法print()不被B继承。
//
//		而B中的public方法print()相当于B添加的一个方法，不属于重写。
//		
		A a = new OverRide().new B();
        a.print();
        B b = new OverRide().new B();
        b.print();
	}
}
