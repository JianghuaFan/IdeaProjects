package AmazonOA;

public class ProductOf1 {
    public int getMaxLen(int[] nums) {
        int positive = 0;
        int negative = 0;
        int res = 0;

        for(int i = 0;i< nums.length;i++){
            int temp = nums[i];

            if(temp == 0){
                positive = 0;
                negative = 0;
            }else if(temp > 0){
                positive++;
                negative = negative == 0 ? 0 : negative+1;
            }else{
                int x = positive;
                positive = negative == 0 ? 0 : negative + 1;
                negative = x + 1;
            }

            res = Math.max(res,positive);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] array = {1, -1, -1, -1, 1, 1};
        ProductOf1 productOf1 = new ProductOf1();
        System.out.println(productOf1.getMaxLen(array));
    }
}
