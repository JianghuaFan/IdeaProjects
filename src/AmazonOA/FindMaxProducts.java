package AmazonOA;

import java.util.*;

public class FindMaxProducts {
    // Time O(n)
// Space O(n)
    public long maximumBooks(int[] books) {
        long[] dp = new long[books.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < books.length; i++){
            int a = 0;
            if(!stack.isEmpty()){
                 a = books[stack.peek()]+i-stack.peek();
            }

            while(!stack.isEmpty() && books[i] < a){
                stack.pop();
            }
            int b = i-books[i]+1;
            int j = stack.isEmpty()? Math.max(0, b) : stack.peek()+1;
            dp[i] = 1L*(books[i]+books[i]-(i-j))*(i-j+1)/2 + (stack.isEmpty()? 0 : dp[j-1]);
            stack.push(i);
        }
        return Arrays.stream(dp).max().getAsLong();
    }
//    public long getMax(List<Integer> product){
//        // highLevel: find a monoStack which is in strict ascending order, find the maximum sum of the monostack
//        // step 1: build the monoStack, at the same time maintain a queue to store the result
//        Deque<Integer> monoStack = new ArrayDeque<>();
//        Queue<Integer> queue = new ArrayDeque<>();
//        for(int i = 0; i < product.size(); i++){
//            Integer cur = product.get(i);
//            Integer peek = monoStack.peekLast();
//            while(!monoStack.isEmpty() && peek > cur){
//                peek--;
//            }
//            monoStack.offerLast(cur);
//            queue.offer(cur);
//        }
//    }
    public static void main(String[] args) {
        FindMaxProducts findMaxProducts = new FindMaxProducts();
        List<Integer> product1 = Arrays.asList(4, 2, 5, 6, 7);
        List<Integer> product2 = Arrays.asList(7, 4, 5, 2, 6, 5);
        int[] p1 = {7, 4, 5, 2, 6, 5};

//        System.out.println("Product List 1: " + product1);
        long result1 = findMaxProducts.maximumBooks(p1);
//        System.out.println("Maximum Number of Products that can be picked 1: " + result1);  // Output: Maximum Number of Products that can be picked 1: 22
        System.out.println(Arrays.stream(p1).findFirst());
        System.out.println(Arrays.stream(p1).max());

        System.out.println(Arrays.stream(Arrays.stream(p1).sequential().toArray()).iterator());
//        System.out.println("Product List 2: " + product2);
//        long result2 = findMaxProducts.maximumBooks(product2);
//        System.out.println("Maximum Number of Products that can be picked 2: " + result2);  // Output: Maximum Number of Products that can be picked 2: 17
    }

}
