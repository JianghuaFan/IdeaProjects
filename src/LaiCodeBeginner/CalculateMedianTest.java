package LaiCodeBeginner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateMedianTest {
    @Test
    public void getMedian(){
        CalculateMedian cm = new CalculateMedian();
        int[] array = {1,2,3};
        int res = cm.calculateMedian(array);
        assertEquals(2,res);
        assertEquals(2,res,0.00001);
    }
    @Test
    public void get_oddUnSorted(){
        CalculateMedian cm = new CalculateMedian();
        int[] array = {2,1,3};
        int res = cm.calculateMedian(array);
        assertEquals(2,res,0.00001);
    }

}