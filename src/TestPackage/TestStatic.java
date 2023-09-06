package TestPackage;

public class TestStatic {
	public static int x = 100;
	public final static int y = 200;
	public static void test(String s){
		System.out.println("s");
	}

	public static void main(String[] args) throws ClassNotFoundException {
		//Object test;
		// TODO Auto-generated method stub
		//public static test = new test();
		test("Test");
		
		System.out.println(TestStatic.y);
		TestStatic tester = new TestStatic();
//		Class t = Class.forName("StaticTest");
		Class.forName("s");

	}

}
