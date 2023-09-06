package cisco;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class MeanNumberModeNumberKSpaceSeparated {
    public static void meanAndModeWithSpaceSeparated(int[] array) {
        if(array == null || array.length == 0){
            System.out.println("array is null or empty");
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        float mean;


        DecimalFormat df = new DecimalFormat("#.00");
        mean = (float)(Math.round( (sum / array.length) * 100) / 100);
//                Float.valueOf(df.format((float)(Math.round(sum / array.length))));
        System.out.println("mean" + mean);

        // step 2: mode number
        int max = -1;
        Integer mode = -1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int number : array){
            int count = 0 ;
            map.put(number, map.getOrDefault(number, 0) + 1);
            count = map.get(number);
            if(count > max){
                max = count;
            }
        }


        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == max){
                mode = entry.getKey();
            }
        }
        System.out.println(mean + " " + mode);
    }

    public static void main(String[] args) {
        int[] array = {1,2,7,3,2};
        MeanNumberModeNumberKSpaceSeparated meanNumberModeNumberKSpaceSeparated = new MeanNumberModeNumberKSpaceSeparated();
        MeanNumberModeNumberKSpaceSeparated.meanAndModeWithSpaceSeparated(array);
    }
}
