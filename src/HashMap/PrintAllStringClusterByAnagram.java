package HashMap;


// Java program to print anagrams
// together using dictionary
import java.util.*;

public class PrintAllStringClusterByAnagram {

    private static void printAnagrams(String arr[])
    {
        HashMap<String, List<String> > map
                = new HashMap<>();

        // loop over all words
        for (int i = 0; i < arr.length; i++) {

            // convert to char array, sort and
            // then re-convert to string
            String word = arr[i];
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String newWord = new String(letters);

            // calculate hashcode of string
            // after sorting
            if (map.containsKey(newWord)) {

                map.get(newWord).add(word);
            }
            else {

                // This is the first time we are
                // adding a word for a specific
                // hashcode
                List<String> words = new ArrayList<>();
                words.add(word);
                map.put(newWord, words);
            }
        }

        // print all the values where size is > 1
        // If you want to print non-anagrams,
        // just print the values having size = 1
        for (String s : map.keySet()) {
            List<String> values = map.get(s);
//            if (values.size() > 1) {
                System.out.print(values);
//            }
        }
    }
    // high level:
    // step1: store all the words by alphabetical order, put them into the map, and corresponding original word in the value
    // step2: print result
    public static void printAllAnagram(String[] array){
        // step 1: sort each word and put into the map
        Map<String, List<String>> map = new HashMap<>();
        for (String word : array) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String newWord = new String(charArray);
            if (map.containsKey(newWord)){
                map.get(newWord).add(word);
            } else {
                List<String> words = new ArrayList<>();
                words.add(word);
                map.put(newWord, words);
            }
        }
//        step2: print
        for(String s: map.keySet()){
            System.out.print(map.get(s));
        }

    }

    public static void main(String[] args)
    {

        // Driver program
        String arr[]
                = { "cat", "dog", "tac", "god", "act" , "bunny"};
        printAnagrams(arr);
        System.out.println();
        printAllAnagram(arr);
    }
}
