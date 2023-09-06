package DFS;
import java.util.HashSet;
import java.util.Scanner;
public class PermutationStringMethod{
	public void permutation(String str) {
		permute(str, "");
	}
	public void permute(String str, String prefix){
		if(str.length() == 0) {
			System.out.println(prefix);
		}
		// Make a boolean array of size '256' which represents all the AsicII code
		//store false by default and make true at the position which character is being used
//		boolean alpha[] = new boolean[256];
		HashSet<Character> set = new HashSet<>();
		for(int i = 0; i < str.length(); i++){
			// Rest of the string after excluding
            // the ith character
			System.out.println("i:" + i);
			char ch = str.charAt(i);
			System.out.println("prefix:" + prefix);
			System.out.println("current char:" + ch);
			String rem1 = str.substring(0, i);
			System.out.println("rem1:" + rem1);
			String rem2 = str.substring(i+1);
			System.out.println("rem2:" + rem2);
			String rem = str.substring(0, i) + str.substring(i+1);
			//If the character has not been used then recursive call will take place.
			//Otherwise, there will be no recursive call 
//			if(alpha[ch - '1'] == false)
			if(!set.contains(ch))
				permute(rem, prefix + ch);
			set.add(ch);
//			alpha[ch - '1'] = true;
		}
	}
	//Driver code
	public static void main(String[] args) {
		// TODO Auto-generated method stub	    
//	    System.out.println("Please input the string you want to permute: ");
//	    Scanner sc = new Scanner(System.in);
//	    String str = sc.nextLine();
//	    sc.close();
		String str = "abc";
		PermutationStringMethod per = new PermutationStringMethod();
		per.permute(str,"");
//		sc.close();
		//System.out.print(str.charAt(1));
	}	
	
}
