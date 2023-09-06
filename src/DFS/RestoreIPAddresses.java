package DFS;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> allPossibleIPAddress(String str){
        // highlevel: DFS, traverse the string, for each section up to three numbers, try all possible IP address, validate the address, add to res

        List<String> res = new ArrayList<>();
        if(str == null || str.length() == 0){
            return res;
        }
        List<String> cur = new ArrayList<>();
        DFS(str, res, cur, 0);
        return res;
    }

    public String generate(List<String> cur){
        StringBuilder sb = new StringBuilder();
        for(String s : cur){
            sb.append(s).append(".");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    public void DFS(String str, List<String> res, List<String> cur, int index){
        // base case
        if(index == str.length()){
            if(cur.size() == 4){
                res.add(generate(cur));
            }
            return;
        }

// recursion rule:
        for(int i = index; i < index + 3 && i < str.length(); i++){
            String tmp = str.substring(index, i + 1);
            if(isValid(tmp)){
                cur.add(tmp);
                DFS(str, res, cur, i + 1);
                cur.remove(cur.size() - 1);
            }
        }

    }

    public boolean isValid(String str) {
// str should be in 0 - 255, no leading zeros
        boolean flag = false;
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0'){
                if(flag == false)
                {
                    flag = true;
                }else{
                    return false;
                }
            }
            num = Integer.parseInt(str);
        }
        if (num < 0 || num > 255) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "12345";
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        System.out.println(restoreIPAddresses.allPossibleIPAddress(str));
    }
}
