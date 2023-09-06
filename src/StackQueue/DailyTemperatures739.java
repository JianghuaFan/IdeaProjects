package StackQueue;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures739 {
	public static int[] dailyTemperature(int[] temperatures) {
		int n = temperatures.length;
		Stack<Integer> indexs = new Stack<>(); 
		int[] dis = new int[n];
		for(int curIndex = 0; curIndex <n; curIndex++) {
			while(!indexs.isEmpty() && temperatures[curIndex] > temperatures[indexs.peek()]) {
				int preIndex = indexs.pop();
				dis[preIndex] = curIndex - preIndex;				
			}
			indexs.add(curIndex);
		}
		return dis;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
		System.out.print(Arrays.toString(dailyTemperature(temperatures)));
	}

}
