package String;

import java.util.*;

/*
Write a Java program to find the penultimate (next to the last) word in a sentence.
 */
public class Penultimate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a Sentence: ");
//        String line = in.nextLine();
        String line = "I like you";
        String[] words = line.split(" ");
        String[] words1 = line.split("\\*");
        for (String word : words) {
            System.out.println(word);
        }
        System.out.println("Penultimate word: " + words[words.length - 2]);

        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("For");
        hashSet.add("Health");
        hashSet.add("Good");
        //Add Duplicate Element
        hashSet.add("Good");
        System.out.println("HashSet: ");
        for (String temp : hashSet) {
            System.out.println(temp);
        }
    }
}
