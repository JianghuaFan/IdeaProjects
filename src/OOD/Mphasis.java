package OOD;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Mphasis {
    public Map<Character, Integer> getFrequency(String name){
        Map<Character, Integer> frequency = new HashMap<>();
        for(int i = 0; i < name.length(); i++){
            char ch = name.charAt(i);
            Integer count = frequency.get(ch);
            if(count == null){
                frequency.put(ch, 1);
            }else{
                frequency.put(ch, count + 1);
            }
        }
        return frequency;
    }

    class employer {
        String name;
        int age;
        float salary;

    }
    public String newName(String name){
        char[] newName = name.toCharArray();
        HashSet<Character> set = new HashSet<>();
        String drop = "aeiou";
        for(char ch : drop.toCharArray()){
            set.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < name.length(); i++){
            char curChar = name.charAt(i);
            if(set.contains(curChar)){
                continue;
            }else{
                sb.append(curChar);
            }
        }
        return sb.toString();
    }

//    table: three columns:
//    id, name,salary,: more than one employer  can have the same salary, rank employers based on the salary, sql,


    public static void main(String[] args) {
        Mphasis mphasis = new Mphasis();
        String name = "Jianghua Fan";
        System.out.println(mphasis.getFrequency(name));
        System.out.println(mphasis.newName(name));
    }

}
