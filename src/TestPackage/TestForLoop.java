package TestPackage;

public class TestForLoop {
	public static void forLoop(int n){
		
		for(int i = 0; i < n; i++) {
			System.out.println("i:" + i);
			//先赋值i， i再自加1
			int a = i++;
			System.out.println("a = i++: " + a);
			System.out.println("new i:" + i);
			//所有循环体内执行完，i++
		}
		System.out.println();
		for(int j = 0; j < n; ++j) {
			System.out.println("j:" + j);
			int b = ++j;
			System.out.println("b = ++j: " + b);
			System.out.println("new j:" + j);
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3; 
		forLoop(n);
		
	}

}
