package DP;

public class CalculatingPermutationCoefficient {
    static int PermutationCoeff(int n,
                                int k)
    {
        int Fn = 1, Fk = 1;

        // Compute n! and (n-k)!
        for (int i = 1; i <= n; i++)
        {
            Fn *= i;
            if (i == n - k)
                Fk = Fn;
        }
        int coeff = Fn / Fk;
        return coeff;
    }

    // Driver Code
    public static void main(String args[])
    {
        int n = 10, k = 1;
        System.out.println("Value of P( " + n + "," + k +") is " + PermutationCoeff(n, k) );
    }

}
