package helloworld;
import java.util.Scanner;


public class Isaprime {
	// 是否为质数	
		static void isPrime(int x) {
		for(int i = 2; i * i < x; i ++) {
			if(x % i == 0) {
				System.out.println("n is not a prime number.");
			}
			else System.out.println("n is a prime number.");
		}		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Input your number: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		isPrime(n);
	}
}