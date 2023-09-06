package helloworld;

public class NumberOf1bits {
	public static int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);        
        int numOf1 = 0;
        if(s.length()>32)
        	return 0;
        for(int i = 0; i < s.length(); i++){
            char ci = s.charAt(i);
            if(ci == '1') {
            	numOf1 ++;
            }
        }
        return numOf1;
    }		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingWeight(7));
	}

}
