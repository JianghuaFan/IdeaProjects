package ArrayMatrix;

public class isAnagram242 {
	public static boolean isAnagram(String s, String t) {
		int n = s.length();
        int nums[] = new int[26];
        for (int i = 0; i < n; i ++) {
            nums[s.charAt(i) - 'a']++;
            nums[t.charAt(i) - 'a']--;
        }
        for (int num : nums) {
        	if( num < 0)
        		return false;
        }              
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  s = "rat", t = "car";
		System.out.print(isAnagram(s,t));

	}

}
