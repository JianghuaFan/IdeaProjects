package BinarySearch;

public class SqrtX {
	public static int sqrtX(int x) {
//		if (x <= 1) return x;
//		int l = 1;
//		int h = x;
//		while (l <= h) {
//			int mid = l + (h - l) / 2;
//			int sqrt = x / mid;
//			if (sqrt == mid)
//				return mid;
//			else if (mid > sqrt) {
//				h = mid - 1;
//			}else
//				l = mid + 1;
//		}
//		return h;
//		
//		int l = 1;
//		int h = x;
//		while (l <= h) {
//			long mid = l + (h - l) / 2;
//			if (x == mid * mid)
//				return (int)mid;
//			else if (x < mid * mid) {
//				h = (int)mid - 1;
//			}else
//				l = (int)mid + 1;
//		}
//		return h;
		long a = x;
        while ( a * a > x) {
            a = (a + x / a) / 2; 
        }
        return (int)a;
		
//		for(int i = 1; i <= x; i++) {
//			if (i * i >= x)
//				return i - 1;
//		}
//		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(sqrtX(5));
		System.out.println(sqrtX(2147395599));
//		System.out.println(sqrtX(2147395599 / 2));
//		System.out.println(Integer.MAX_VALUE);

	}

}
