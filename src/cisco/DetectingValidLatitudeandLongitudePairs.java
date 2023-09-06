package cisco;

import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DetectingValidLatitudeandLongitudePairs {

        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            sc.nextLine(); // consume the newline character

            Pattern p = Pattern.compile("\\([\\+\\-]?(?:90(?:\\.0+)?|[0-8][0-9](?:\\.\\d+)?|[0-9](?:\\.\\d+)?),\\s[\\+\\-]?(?:180(?:\\.0+)?|[0-1][0-7][0-9](?:\\.\\d+)?|[0-9][0-9](?:\\.\\d+)?|[0-9](?:\\.\\d+)?)\\)");

            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                Matcher m = p.matcher(line);
                if (m.find()) {
                    System.out.println("Valid");
                } else {
                    System.out.println("Invalid");
                }
            }
        }


}
