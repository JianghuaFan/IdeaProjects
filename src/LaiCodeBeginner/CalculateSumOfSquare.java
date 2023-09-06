package LaiCodeBeginner;

public class CalculateSumOfSquare {
	public static int sumOfSquares(int n) {
	    // Write your solution here
		if (n == 0)
		    return 0;
	    if(n == 1)
		    return 1;

		  int sum = 0;	    
		  for (int i = 0; i <= n; i++) {
		    for (int j = 1; j <= n / 2; j++ )
		    if (i / j == j && i % j == 0) {
		      sum += i;
		    }
		  }
		  return sum;
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(sumOfSquares(1));
	}

}
