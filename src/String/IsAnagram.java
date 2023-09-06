package String;

public class IsAnagram {

	public static boolean isAnagram(String s, String t) {
		int cnts[] = new int[26];
		for(char c : s.toCharArray()) {
			cnts[c - 'a']++;
		}
		for(char c : t.toCharArray()) {
			cnts[c - 'a']--;
		}
		for(int cnt :cnts) {
			if(cnt!=0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "fdgdgf";
		String t = "fdfgdg";
		System.out.print(isAnagram(s,t));

	}
}
