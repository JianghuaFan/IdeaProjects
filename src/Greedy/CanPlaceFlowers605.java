package Greedy;

public class CanPlaceFlowers605 {
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count = 0;
        
        for(int i = 0; i < flowerbed.length; i++ ) {
            if (flowerbed[i] == 1)
                continue;
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
            if(pre == 0 && next == 0) {
                flowerbed[i] = 1;
                count++;
            }                       
        }
        if(count >= n)
            return true;
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] flowerbed = {1};
		int n = 0;
		System.out.print(canPlaceFlowers(flowerbed,n));
	}

}
