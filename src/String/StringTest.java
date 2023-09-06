package String;

public class StringTest {
	public static String concatenate(String x, String y) {
//		String z = x +"," + y;
		String z = x.concat("," + y);
		return z;
	}
	public static double divideWithoutOfPrecision(int a, int b) {
		double c = (float)a / b; 
		return c;
	}
	public static int divideToCeiling(int x, int y) {
		int floor = x / y;
		int remainder = x % y;
		int res = remainder > 0 ? 1 : 0;
		int ceil = floor + res;
		System.out.println("只保留整数：" + floor + " ," + (res > 0 ? "余数大于0" : "余数为0") + "向上取整" + ceil);
		return ceil;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "hello";
		String y = "world";
//		System.out.println(concatenate(x,y));
		
//		System.out.println(divide(3,7));
		double d = 100d / 123;
		System.out.println((int)d);
		System.out.println((int)Math.ceil(d));
		System.out.println(divideToCeiling(100,123));
		System.out.print("中文乱码");
		StringBuffer s = new StringBuffer();
		String a = "a";
		String b = "b";
		s.append(a).append(b);
		System.out.print(s);
	}

}
