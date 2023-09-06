package MonoStack;

import java.util.*;

public class MaximumValuesOfSizeKSlidingWindows {
    public List<Integer> maxWindows(int[] array, int k) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        Deque<Integer> monoStack = new ArrayDeque<>();
        for(int i = 0; i < array.length; i++){
            int newGrad = array[i];

            // step 1: before adding fast, we need to check stack is not ascending
            // 维护单调非递增的单调栈，里面存的是index，新来的可以比老的小，所以可以递减或者相等。但是不能递增，比如新来的大，老的一定得走
            while(!monoStack.isEmpty() && array[monoStack.peekLast()] <= newGrad){
                monoStack.pollLast();
            }
            // step 1.1: add fast
            monoStack.offerLast(i);

            // step 2: remove slow: 正常退休的：  栈顶元素是当前元素往前k个，表示当前window长度就是k，需要把栈顶元素退休再入栈新元素
            if(!monoStack.isEmpty() && monoStack.peekFirst() <= i - k){
                monoStack.pollFirst();
            }
            // step 3: update result
            if(i >= k - 1){
                res.add(array[monoStack.peekFirst()]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumValuesOfSizeKSlidingWindows maximumValuesOfSizeKSlidingWindows = new MaximumValuesOfSizeKSlidingWindows();
//        int[] array = {1,2,3,2,4,2,1};
        int k = 3;
//        int[] array = {5,2,1,4,3,6,2,8,3,1,4};
        int[] array = {1,2,3,1,1};
        System.out.println(maximumValuesOfSizeKSlidingWindows.maxWindows(array,2));
    }
}
