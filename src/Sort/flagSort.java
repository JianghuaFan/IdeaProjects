package Sort;

import java.util.Arrays;

public class flagSort {
    public int[] sort(int[] input){
        int zero = 0;
        int one = 0;
        int two = input.length - 1;
        while(one < two){
            if(input[one] == 0){
                swap(input, one++, zero++);
            }else if(input[one] == 2){
                swap(input, one, two--);
            } else{
                one++;
            }
        }
        return input;
    }
    private void swap(int[] input, int x, int y){
        int temp = input[x];
        input[x] = input[y];
        input[y] = temp;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] input = {2,0,2,1,1,0};
        flagSort test =new flagSort();
        System.out.println(Arrays.toString(test.sort(input)));
    }
}
