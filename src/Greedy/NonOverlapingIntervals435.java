package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NonOverlapingIntervals435 {
	public int eraseMinimumOverlapingIntervals(int[][] intervals) {
		int cnt = 0;
		
		if (intervals.length == 0) return 0;
		Arrays.sort(intervals, new Comparator<int[]>(){
			@Override
			public int compare(int[] i1, int[] i2){
				return i1[1] - i2[1];
			}
		});
		Arrays.sort(intervals, new MyComparator());
		for (int i = 0; i < intervals.length; ) {
			int j = i + 1;
			while (j < intervals.length && intervals[j][0] < intervals[i][1]) {
				j++; //有重叠就跳过该区间					
			}			
			i = j;//新起点是j
			cnt++;//统计多少区间可以保留
			
		}
//		if (intervals.length == 0) {
//	        return 0;
//	    }
//		Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
//	    int cnt = 1;
//	    int end = intervals[0][1];
//	    for (int i = 1; i < intervals.length; i++) {
//	        if (intervals[i][0] < end) {
//	            continue;
//	        }
//	        end = intervals[i][1];
//	        cnt++;
//	    }
//		Comparator comparator = new Comparator<int[]>() {
//			@Override
//			public int compare (int[] o1, int[] o2) {
//				return o1[1] < o2[1] ? -1 : ((o1[1] == o2[1]) ? 0 : 1);
//			}
//		};
/*		An instance of an inner class cannot be created without an instance of the outer class. Therefore, 
		an inner class instance can access all of the members of its outer class, 
		without using a reference to the outer class instance. For this reason, 
		inner classes can help make programs simple and concise. 
		/*新建一个类的对象a， a中定义了类comparator（实现了接口Comparator且重写的compare方法），
//		实例化一个类comparator的对象com，则对象com包含了compare方法，Arrays.sort就可以调用该方法
		NonOverlapingIntervals435 a = new NonOverlapingIntervals435();		
		comparator com = a.new comparator();
		*/
		//或者直接合并为下面这句代码，instantiate外部类.内部类
//		comparator com = new NonOverlapingIntervals435().new comparator();
//		或者写成实例化comparator，，该类实现了接口Comparator，类似于List<Integer> list = new ArrayList<>();左边是接口，右边是该接口的实现类
		Comparator<int[]> com = new NonOverlapingIntervals435().new MyComparator();
		Arrays.sort(intervals, com);	
//		List<Integer> list = new ArrayList<>();
//		Arrays.sort(intervals, new Comparator<int[]>() {
//	     @Override
//	     public int compare(int[] o1, int[] o2) {
//	         return (o1[1] < o2[1]) ? -1 : ((o1[1] == o2[1]) ? 0 : 1);
//	     }
//	});
	return intervals.length - cnt;

	}
	
	// Comparator接口不能被实例化，需要新建一个类comparator实现Comparator接口，（comparator不是抽象类，需要重写接口的所有方法）然
//	后再创建该类的对象com, Arrays.sort(数组，比较器)时候可以直接调用实例化好的com
	
	public  class MyComparator implements Comparator<int[]> {
		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[1] < o2[1])
				return -1;
			else if (o1[1] == o2[1])
				return 0;
			return 1;
		}
	}
	
	public static void main(String[] args) {
		NonOverlapingIntervals435 nonOverlapingIntervals435 = new NonOverlapingIntervals435();
		// TODO Auto-generated method stub
		for(int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		if (args[0].equals("hey")){
//			do this
		}else if (args[0].equals("hi")){
//			do this
		}
		int[][] intervals = {{1,2},{2,3},{3,4},{1,3},{2,3}};
		System.out.print(nonOverlapingIntervals435.eraseMinimumOverlapingIntervals(intervals));
	}

}
