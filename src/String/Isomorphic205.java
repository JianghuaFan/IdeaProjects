package String;

public class Isomorphic205 {
	//记录一个字符上次出现的位置，如果两个字符串中的字符上次出现的位置一样，那么就属于同构
	public static boolean isomorphic(String s, String t) {
	/* 方法二 
	 *  char[] sToT = new char[256];//ascii 码表里有256个字符可能性，所以需要256长度的字符数组
		char[] tToS = new char[256];
		for(int i = 0; i < s.length(); i++) {
			char sChar = s.charAt(i);
			char tChar = t.charAt(i);
			if(sToT[sChar] ==0 && tToS[tChar] == 0) {
				sToT[sChar] = tChar;
				tToS[tChar] = sChar;
			}else if(sToT[sChar] != tChar) {
				return false;
			}
		*/
			/* s = "foo", t = "bar";
			   1) sToT['f'] = 'b' and tToS['b'] = 'f';
			   2) sToT['o'] = 'a' and tToS['a'] = 'o';
			   3) sToT['o'] = 'a', tChar = 'r';
			  retrurn  false;
			   s = "egg", t = "add";
			   1) sToT['e'] = 'a' and tToS['a'] = 'e';
			   2) sToT['g'] = 'd' and tToS['d'] = 'g';
			   3) sToT['g'] = 'd', tChar = 'd';
			  retrurn  false;
			  */
		    int[] preIndexOfS = new int[256];
		    int[] preIndexOfT = new int[256];
			for(int i = 0; i < s.length(); i++) {
				char sc = s.charAt(i);
				char tc = t.charAt(i);
				if(preIndexOfS[sc] != preIndexOfT[tc]) return false;
				preIndexOfS[sc] = i+1;
				preIndexOfT[tc] = i+1;			
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "foo";
		String t = "bar";
		System.out.print(isomorphic(s,t));
	}

}
