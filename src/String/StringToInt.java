package String;

public class StringToInt {
	public int stringToInt(String input) {
		if(input == null || input.length() == 0) {
			return 0;
		}
		int number = 0;
		for(int i = 0; i < input.length(); i++) {
			int cur = input.charAt(i) - '0';
			System.out.println(cur);
			number = number * 10 + cur;
		}
		return number;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringToInt StirngToInt = new StringToInt();
		String input = "1912";
		System.out.println(StirngToInt.stringToInt(input));

	}

}
