package String;

public class StringHasCodeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a =2;
//		System.out.print(Integer.hashCode(a));
//		System.out.print(Integer.toHexString(a));
		String str1 = "人间正道";
		
		System.out.println("str1的 hascode：" + str1.hashCode());
		
		str1 = str1 + "是沧桑";		
		
		System.out.println("添加字后str1的 hascode：" + str1.hashCode());
		
		System.out.println(str1);
		
		System.out.println();
		
		StringBuffer str2 = new StringBuffer("学海无涯");
		
		System.out.println("StringBuffer的str2的 hascode：" + str2.hashCode());
		
		str2.append("苦作舟");
		
		System.out.println("添加字后StringBuffer的str2的 hascode：" + str2.hashCode());
		
		System.out.println(str2);
	}

}
