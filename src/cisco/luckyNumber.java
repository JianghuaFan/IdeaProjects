package cisco;

public class luckyNumber {
        public static int counter = 2;

        // Returns 1 if n is a lucky no.
        // otherwise returns 0
        static boolean isLucky(int n)
        {
            if (counter > n)
                return true;
            if (n % counter == 0)
                return false;

        /*calculate next position of input no.
        Variable "next_position" is just for
        readability of the program we can
        remove it and update in "n" only */
            int next_position = n - (n / counter);

            counter++;
            return isLucky(next_position);
        }

        // Driver code
        public static void main(String[] args)
        {
            int x = 13;

            // Function call
            if (isLucky(x))
                System.out.println(x + " is a lucky no.");
            else
                System.out.println(x + " is not a lucky no.");
        }

}
