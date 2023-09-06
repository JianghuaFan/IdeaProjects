package String;

public class CountBinarySubstring {
	//统计二进制字符串中连续1和连续0数量相同的子字符串个数
	//Input： "00110011"  Output: 6
	//Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
	//private static int count = 0;
	public static int countBinarySubstring(String s){
		/*方法二
		int preLen = 0, curLen = 1, count = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                curLen++;
            }
            else{
                preLen = curLen;
                curLen = 1;
            }
            if(preLen >= curLen){
                count++;
            }
        }        
        return count;
		*/
		int curLen = 1, preLen = 0, count = 0;
		for(int i = 1; i < s.length(); i++) {
			if (s.charAt(i)!= s.charAt(i-1)) {
				count += Math.min(preLen,curLen);
				preLen = curLen; 
				curLen = 1;				
			}else {
				curLen ++;
			}			
		}
		return count += Math.min(curLen,preLen);		
	}	
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(countBinarySubstring("00110011"));
	}
}
