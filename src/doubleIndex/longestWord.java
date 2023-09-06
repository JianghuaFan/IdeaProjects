package doubleIndex;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class longestWord {
	
	public static String findLongestWord(String s, List<String>d) {
		String longestWord = "";
		d.sort((a,b) ->{
			if(a.length() != b.length()) {
				return Integer.compare(b.length(), a.length());
			}
			return a.compareTo(b);
		});
		
		for(String target: d) {
			int l1 = longestWord.length(), l2 = target.length();
			//è¿”å›žæ›´é•¿çš„å­�åº�åˆ—ï¼Œå¦‚æžœé•¿åº¦ç›¸å�Œè¿”å›žå­—å…¸åº�é� å‰�çš„
			if(l1 > l2 || l1 == l2 && longestWord.compareTo(target) < 0 ) {
				continue;
			}
			if(isSubString(s,target)) {
				return longestWord = target;
			}
		}
		return longestWord;
		
	}
		private static boolean isSubString(String s, String target) {
			int i = 0, j = 0; 
			while (i < s.length() && j  < target.length())
			{
				if (s.charAt(i) == target.charAt(j)) {
				j++; 
				}
				i++;
			}
			if( j == target.length()) {
			return true;
			} 
			else {
			return false;
			}
		}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Please input the array of words you are looking for:");
		//Scanner sc = new Scanner(System.in);
		List<String> word = new ArrayList<String>();
		word.add("apple");
		word.add("ale");
		word.add("monk");
		word.add("cindy");
		//while(sc.hasNextLine()) {
			//word.add(sc.nextLine());
//		}
		//word.add(sc.nextLine());
		System.out.print("Please input the string you are looking into:");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		findLongestWord(str, word);
		System.out.print(findLongestWord(str, word));

	}

}
