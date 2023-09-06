package LaiCodeBeginner;

import java.util.Arrays;

public class CalculateMedian {
    public int calculateMedian(int[] array){
        Arrays.sort(array);
        return array[array.length / 2];
    }
}
