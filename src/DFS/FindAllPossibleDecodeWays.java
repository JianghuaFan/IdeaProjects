package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
The decoding scheme is:

1 -> A

2 -> B

…

10 -> J

11 -> K

12 -> L

…

21 -> U

22 -> V

...

26 -> Z



e.g. Given input String  "1121"

It can be decoded as

[ "AABA",

  "AAU",

  "ALA",

  "KBA",

  "KU"

]

return all the possible decode ways, or just print out all decodes ways

                    1 1 2 1
                 /           \
                A121          K 21
               /   \          /  \
            AA21   AL1       KB1  KU
          /    \     |         |
        AAB1   AAU  ALA       KBA
        |
        AABA
 */
public class FindAllPossibleDecodeWays {
    // TC: branch 2:  level: input.length() 2^n
    // SC: O(n)
    public List<String> decode(String input){
        if(input == null || input.length() == 0){
            return new ArrayList<>();
        }
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        DFS(input, sb, res, 0);
        return res;
    }

    private void DFS(String input, StringBuilder sb, List<String> res, int index) {
        // base case: we have traversed the input string
        if(index == input.length()){
            res.add((sb.toString()));
            return;
        }
        //case 1: add one letter of input string
        int num = input.charAt(index) - '0';
        char ch1 = (char) ( num - 1 + 'A');
        if(num >= 1 && num <= 9){
            sb.append(ch1);
            DFS(input, sb, res, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        // case 2: add two letter of input string
        if(index + 1 < input.length()){
            num = num * 10 + (input.charAt(index + 1) - '0');
            if(num >= 10 && num <=26){
                char ch2 = (char)(num - 1 + 'A');
                sb.append(ch2);
                DFS(input, sb, res, index + 2);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
/*
求多少种decode方式， input: s = "226", output: 3, Explanation: "226" could be decoded as "BZ(2 26)", "VF"(22 6), "BBF"( 2 2 6)
 */
    public int allDecodeWaysDP(String input){
        if(input == null || input.length() == 0){
            return 0;
        }
        // dp[i]物理意义： 前i个字符构成的decode方法数
        int[] dp = new int[input.length() + 1];
        // base case:
        dp[0] = 1;
        dp[1] = input.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= input.length(); i++){
            // case 1: 留最后一个字符， 那么就依赖于前i - 1个字符的解码方式
            int one = input.charAt(i - 1) - '0';
            if(one >= 1 && one <= 9){
                dp[i] += dp[i-1];
            }
            // case 2: 留最后两个字符， 那么就依赖于前i - 1个字符的解码方式
            int two = (input.charAt(i - 2) - '0' )* 10 + input.charAt(i - 1) - '0';
            if(two >= 10 && two <= 26){
                dp[i] += dp[i-2];
            }

        }
        return dp[input.length()];
    }

    // n queens method, 还没实现
    public List<String> findAllDecodeWays(String input){
        Map<Integer, String> map = buildMap();
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        DFSII(input, sb, 0, map, res);
        return res;
    }
    private void DFSII(String input, StringBuilder sb , int index, Map<Integer, String> map, List<String> res){
        // base case:
        if(index == input.length()){
            res.add(sb.toString());
            return;
        }
        for(int  j = index; j <= index + 1; j++){
            if( j < input.length()){
                int num = getNum(input,index,j);
                String str = map.get(num);
                sb.append(str);
                DFSII(input, sb, index + 1, map, res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private int getNum(String input, int index, int j) {
        int num = input.charAt(index) - '0';
        if(index == j - 1){
            num = num * 10 + input.charAt(index + 1) - '0';
        }
        return num;
    }

    private Map<Integer, String>buildMap(){
        Map<Integer, String> map = new HashMap<>();
        String name;
        for(int i = 1; i <=26; i++){
            name = String.valueOf((char)(96+i)).toUpperCase();
            map.put(i, name);
        }
        return map;
    }


    public static void main(String[] args) {
        String num = "1121";
        FindAllPossibleDecodeWays findAllPossibleDecodeWays = new FindAllPossibleDecodeWays();
        System.out.println(findAllPossibleDecodeWays.decode("326"));
        System.out.println(findAllPossibleDecodeWays.findAllDecodeWays(num));
        System.out.println(findAllPossibleDecodeWays.allDecodeWaysDP("0"));
    }

}
