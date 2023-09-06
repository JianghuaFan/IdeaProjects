package DP;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
/area of the box
Given aox of ethernet cables with dimension? rows * columns.choose a xa groups for all a such
that 1 <= a <= min(rows,columns. Determine the
number of ways the box of cables can be divided
There are 3 5- 15ways to choose a / x  area of cables
There are ip 4- 8 ways to choose a 2 x 2 area of cables
There are 1*3_B ways to choose a 3 x 3 area of in total there are 15 + 8 + 3 -26ways the box can be divided.
/
 */
public class AreaOfTheBox {
    public List<Long> numberOfWays(List<List<Integer>> queries){
        List<Long> res = new ArrayList<>();
        // highlevel:for each query,
        for(List<Integer> query : queries){
            long count = 0;
            int r = query.get(0);
            int c = query.get(1);

            while(r > 0 && c > 0){
                count += r * c;
                r--;
                c--;
            }
            res.add(count);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(3,5)));
        AreaOfTheBox areaOfTheBox = new AreaOfTheBox();
        System.out.println(areaOfTheBox.numberOfWays(list).toString());
    }
}
