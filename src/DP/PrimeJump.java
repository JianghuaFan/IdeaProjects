package DP;

import java.util.Scanner;
import java.util.*;
public class PrimeJump {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] cells = new int[n];
            for (int i = 0; i < n; i++) {
                cells[i] = sc.nextInt();
            }
            int[] dp = new int[n];
            dp[0] = cells[0];
            for (int i = 1; i < n; i++) {
                dp[i] = cells[i];
                for (int j = 2; j <= i + 1; j++) {
                    if (isPrime(j) && j % 10 == 3) {
                        dp[i] = Math.max(dp[i], cells[i] + dp[i - j]);
                    }
                }
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
            System.out.println(dp[n - 1]);
        }

        public static boolean isPrime(int n) {
            if (n < 2) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }

}
