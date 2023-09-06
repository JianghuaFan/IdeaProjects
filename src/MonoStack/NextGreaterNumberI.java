package MonoStack;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

public class NextGreaterNumberI {
    public int[] nextGreaterElement(int[] partial, int[] all) {
        // Write your solution here
        // TC: O(n) SC: O(n)
        // res 存结果， monoStack维护单调递减栈， 每遇到比栈顶大的元素就替换栈顶元素，且栈顶元素的对应的比他大的结果就是当前替换自己的元素
        int[] res = new int[partial.length];
        Deque<Integer> monoStack = new ArrayDeque<>();
        HashMap<Integer, Integer> position = new HashMap<>();
        //
        for(int i = 0; i < all.length; i++){
            while(!monoStack.isEmpty() && monoStack.peekFirst() <= all[i]){
                int element = monoStack.pollFirst();
                position.put(element, all[i]);
            }
            monoStack.offerFirst(all[i]);
        }
        // 填结果： case1 还留在栈里的说明没有人替换她们，结果为-1
        // case 2: 被替换过的存在了map里
        for(int i = 0; i < partial.length; i++){
            res[i] = position.getOrDefault(partial[i], -1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] all = {3,4,1,2};
        int[] partial = {4,1,2};
        NextGreaterNumberI nextGreaterNumberI = new NextGreaterNumberI();
        System.out.println(Arrays.toString(nextGreaterNumberI.nextGreaterElement(partial,all)));
    }
}
