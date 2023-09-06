package String;
/*
When two binary strings are added, then the sum returned is also a binary string.

Example:
Input :  x = "10", y = "01"
Output: "11"
Input :  x = "110", y = "011"
Output: "1001"
Explanation:
  110
+ 011
=1001
 */
public class AddTwoBinaryStrings {

    public String addTwoBinaryStrings(String x, String y){
        // Approach 1:
//        int num1 = Integer.parseInt(x, 2);
//        // converting binary string into integer(decimal number)
//
//        int num2 = Integer.parseInt(y, 2);
//        // converting binary string into integer(decimal number)
//
//        int sum = num1 + num2;
//        // Adding those two decimal numbers and storing in sum
//
//        String result = Integer.toBinaryString(sum);
//        // Converting that resultant decimal into binary string
//
//        return result;
        // Approach 2: two pointers
        int i = x.length() - 1, j = y.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += x.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += y.charAt(j) - '0';
            }
            if (sum == 0 || sum == 1) {
                result.append(sum);
                carry = 0;
            }
            else if (sum == 2) {
                result.append("0");
                carry = 1;
            }
            else {
                result.append("1");
                carry = 1;
            }
            i--;
            j--;
        }
        if (carry == 1) {
            result.append("1");
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "123";
        System.out.println("charAt 0: " + str.charAt(0));
        System.out.println("charAt 1: " + str.charAt(1));
        System.out.println("charAt 2: " + str.charAt(2));
        String x = "011011";
        String y = "1010111";
        System.out.println("charAt 0: " + x.charAt(0));
        System.out.println("charAt 1: " + x.charAt(1));
        System.out.println("charAt 2: " + x.charAt(2));
        AddTwoBinaryStrings addTwoBinaryStrings = new AddTwoBinaryStrings();
        addTwoBinaryStrings.addTwoBinaryStrings(x, y);
    }
}
