package ArrayMatrix;

public class ArrayNesting565 {
	public static int arrayNesting(int[] nums) {
//		 方法一：
         int max = 0;
         // S[i] 表示一个集合，集合的第一个元素是 A[i]，第二个元素是 A[A[i]]，如此嵌套下去。求最大的 S[i]
         for(int i = 0; i < nums.length; i++) {
             int count = 0;
             for(int j = i; nums[j] != -1;) {
                 count ++;
                 int t = nums[j];
                 nums[j] = -1;
                 j = t;
             }
             max = Math.max(max, count);
         }
         return max;
        // 方法二：
//		int max = 0;
//		boolean[] visited = new boolean[nums.length];
//		for (int i = 0; i < nums.length; ++i) {
//			if(visited[i] == true) continue;
//			max = Math.max(max,helper(nums, i, visited)); 
//		}
//		return max;
		
	}

//	private static int helper(int[] nums, int start, boolean[] visited) {
//		int count = 0;
//		int i = start;
//		while( count == 0 || i != start) {
//			visited[i] = true;
//			i = nums[i];
//			count++;
//		}
//		// TODO Auto-generated method stub
//		return count;
//	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,4,0,3,1,6,2};
		System.out.print(arrayNesting(nums));
	}

}
