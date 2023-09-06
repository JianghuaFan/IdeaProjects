package HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum1 {
	public static int[] twoSum(int[] nums, int target) {
		/*Map<Integer,Integer> sumM = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {			
			if(sumM.containsKey(target - nums[i])) {			
				//int[] sum1 = new int[]{sumM.get(target -nums[i]),i};
				//return sum1;
				return new int[]{sumM.get(target -nums[i]),i};
			}else {
				sumM.put(nums[i], i);
			}
		}
		return null;
		*/
		HashMap<Integer, Integer> sum = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(sum.containsKey(target - nums[i])){
                return new int[]{sum.get(target - nums[i]),i};
            }else{
                sum.put(nums[i], i);
            }
        }
        return null;
	}
    public int[] findTwoProduct(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0 && map.containsKey(0)) {
                result[0] = 0;
                result[1] = 0;
                return result;
            }
            if (num != 0 && target % num == 0 && map.containsKey(target / num)) {
                result[0] = num;
                result[1] = target / num;
                return result;
            }
            map.put(num, i);
        }

        return result; // Return an array with default values if no solution is found
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        TwoSum1 solution = new TwoSum1();
        int[] nums2 = {0, 4, 8, 10};
        int target = 0;
        int[] result = solution.findTwoProduct(nums2, target);
        System.out.println(" findTwoProduct: " + Arrays.toString(result));

		int[] nums1 = {2,7,9,11};
		System.out.println(Arrays.toString(twoSum(nums1,9)));
        System.out.println(Arrays.toString(solution.findTwoProduct(nums1,18)));

    }
}
