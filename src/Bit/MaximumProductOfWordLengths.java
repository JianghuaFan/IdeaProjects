package Bit;

public class MaximumProductOfWordLengths {
	public static int maxProduct(String[] words) {
		int n = words.length;
        int[] val = new int[n];
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for( char c : words[i].toCharArray()) {
                val[i] |= 1 << (c - 'a');
            }
            System.out.println(Integer.toBinaryString(val[i]));
            
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if((val[i] & val[j]) == 0)
                    ret = Math.max(ret, words[i].length() * words[j].length()); 
            }
        }
        return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"abcw","xtfn","abcdef"};
		System.out.print(maxProduct(words));

	}

}
