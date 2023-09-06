package OOD;

public class ContinueBreakReturnTest {
	public static void ContinueTest() {
		for ( int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				System.out.println("没有执行continue语句" + i);
			else
				System.out.println("执行了continue语句,跳出当前循环！");
				continue;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BreakTest();
		ContinueTest();
		ReturnTest();
	}

	private static void BreakTest() {
		// TODO Auto-generated method stub
		for ( int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				System.out.println("没有执行break语句" + i);
			else {
				System.out.println("执行了break语句,跳出当前循环！");
				break;
			}
		}
	}

	private static void ReturnTest() {
		// TODO Auto-generated method stub
		for ( int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				System.out.println("没有执行return语句" + i);
			else {
				System.out.println("执行了return语句,直接跳出了当前的testReturn方法！");
				return;
			}
		}
	}

}
