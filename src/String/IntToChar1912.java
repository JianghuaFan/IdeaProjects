package String;

public class IntToChar1912 {
//	public String intToChar(int i) {
//		StringBuilder sb = new StringBuilder();
//		while(i != 0) {
//			sb.append(i%10 + '0');
//			System.out.println(i%10);
//			i /= 10;
//		}		
//		sb.reverse();
//		return sb.toString();		 
//	}
	public String intToChar(int number){
		StringBuilder res = new StringBuilder();
		while (number != 0) {
			int rem = number % 10;
//			res.append(rem + '0');//错误的，把数字rem加上0的ascII码，成了2+48。 
			res.append(rem);
			number /= 10;
		}
	return res.reverse().toString();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntToChar1912 intToChar = new IntToChar1912();
		System.out.println(intToChar.intToChar(1912));
		StringBuilder sb = new StringBuilder();		
		int rem = 97;
		System.out.println(rem + '0');//97+48 = 145
		System.out.println("rem + '0': " + rem + '0');//处理成一串字符串了9 7 0
		char c = (char)rem;
		System.out.println("c:" + c);// int to char,得到c（ASCII码）为97的字母'a'
		System.out.println("(char)rem: "  + (char)rem);

		int i = 98;
		System.out.println(98 - 'a');// 98 - 97
		char x = 98 - 'a';
		int b = 'b';
		System.out.println(x);
		System.out.println(b);//char 到int自动转换
		
	}

}
