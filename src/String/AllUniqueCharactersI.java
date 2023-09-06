package String;

public class AllUniqueCharactersI {
	public boolean allUnique(String word) {
	    // Write your solution here
	    if(word == null || word.length() == 0){
	      return true;
	    }
	   
	    boolean[] seen = new boolean[256];
	    for( char ch : word.toCharArray()){
	      int index = ch - 0;
//	      int index = (int)ch;
	      System.out.println(ch);
	      if(seen[index] == true){
	        return false;
	      }
	      seen[index] = true;
	    }
	    return true;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllUniqueCharactersI unique = new AllUniqueCharactersI();
		String word = "abA+\\8";
		System.out.print(unique.allUnique(word));
	}

}
