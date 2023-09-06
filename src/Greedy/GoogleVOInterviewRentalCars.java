package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class GoogleVOInterviewRentalCars {

    public int rentalCarsExpected(int[][] records){
        Arrays.sort(records, (int[] r1, int[] r2 ) -> r1[1] - r2[1]); // int[] r1, int[] r2

        int count = 1;
        Arrays.sort(records, new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                return i1[1] - i2[1];
            }
        });
        int[] prev = records[0];
        for(int i = 1; i < records.length; i++){
            if(prev[1] > records[i][0]){
                count++;
            }
//            prev = prev[1] < records[i][1] ? records[i] : prev;
            if(prev[1] < records[i][1]){
                prev = records[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] records =  {{0,1},{1,3},{2,4},{3,6}};
        GoogleVOInterviewRentalCars googleVOInterviewRentalCars = new GoogleVOInterviewRentalCars();
        System.out.println(googleVOInterviewRentalCars.rentalCarsExpected(records));
    }
}
