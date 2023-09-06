package MonoStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
/*
找到数组中右边第一个比自己小的元素。如果没有填-1.单调栈递增，栈里元素单调递增
int[] array = {3,1,2,5,4,6,3}，[1, -1, -1, 4, 3, 3, -1]
 */
public class FirstSmallerElementOnRight {
    public int[] firstSmallerOnRight(int[] array){
        int[] res = new int[array.length];
        Arrays.fill(res, - 1);
        Deque<Integer> monoDeque = new ArrayDeque<>();
        for(int i = 0; i < array.length; i++) {
            while(!monoDeque.isEmpty() && array[monoDeque.peekFirst()] >= array[i] ){
                res[monoDeque.peekFirst()] = array[i];
                monoDeque.poll();
            }
            monoDeque.offerFirst(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {3,1,2,5,4,6,3};
        FirstSmallerElementOnRight firstSmallerElementOnRight = new FirstSmallerElementOnRight();
        System.out.println(Arrays.toString(firstSmallerElementOnRight.firstSmallerOnRight(array)));
    }
}
