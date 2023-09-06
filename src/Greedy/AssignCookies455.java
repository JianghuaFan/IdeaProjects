package Greedy;

import java.util.Arrays;

public class AssignCookies455 {
	public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
        	if(s[si] >= g[gi])
        		gi++;
        	si++;
        }
        return gi;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] g = {1,2,3};
		int[] s = {1,1,3};
		System.out.print(findContentChildren(g,s));

	}

}
