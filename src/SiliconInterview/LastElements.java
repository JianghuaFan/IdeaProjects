package SiliconInterview;

import java.util.*;
import java.util.stream.Collectors;

public class LastElements {
    public List<Integer> lastElements(List<Integer> arr){
        Stack<Integer> stack = new Stack<>();
        for (Integer num : arr) {
            if (num > 0) {
                stack.push(num);
            }else {
                if (stack.isEmpty()) {
                    stack.push(num);
                    continue;
                }else if(stack.peek() < 0){
                    stack.push(num);
                }
                if (Math.abs(stack.peek()) > Math.abs(num)) {
                    continue;
                }
                while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(stack.peek()) < Math.abs(num)) {
                    stack.pop();
                }

                if (stack.peek() > 0 && Math.abs(stack.peek()) == Math.abs(num)) {
                    stack.pop();
                    continue;
                }

            }
        }

        return new ArrayList<>(stack);
    }

    public boolean isDivisibleBy8(int myInt){
        boolean isDivisibleBy8 =
//        myInt / 8 ? true: false;

        myInt % 8 == 0;
//        myInt % 8 != 8;
//        Math.isDivisible(myInt,8)
                return isDivisibleBy8;
    }

    public void stackTest(){
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);
        System.out.println("stack: which iterate the elements from bottom to top:" + new ArrayList<>(stack) );
        System.out.println("deque: which iterate the elements from top to bottom:" + new ArrayList<>(deque) );
    }

    public static void main(String[] args) {
//        Integer[] array = {5,-5, -6, -7};
//        Integer[] array2 = {3,-4,2,-1,6,4,-5};
//
//        List<Integer> arr = Arrays.asList(array);
//        LastElements lastElements = new LastElements();
//
//        System.out.println(lastElements.lastElements(arr));
//        lastElements.stackTest();

//        LastElements lastElements = new LastElements();
//        System.out.println(lastElements.isDivisibleBy8(8));
//        Object myobj = new Integer(5);
//        String myStr = (String) myobj;
//        System.out.println(myStr);
        List<String> names = new ArrayList<>();
        names.add("Cindy");
        names.add("Andy");

//        names.sort(Comparator.comparing(String :: toString));
//        Collections.sort(names);
        names.stream().sorted((s1,s2) -> s1.compareTo(s2)).collect(Collectors.toList());
//        names.sort(List.DESCENDING);
        System.out.println(names);
    }
}
