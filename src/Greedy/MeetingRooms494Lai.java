package Greedy;

import java.util.*;

public class MeetingRooms494Lai {
	public int minMeetingRoomsStack(int[][] intervals) {
		int cnt = 0;
	    if (intervals == null)
	      return cnt;
	    //会议按照开始时间排序
	    Arrays.sort(intervals, new Comparator<int[]>(){
	      @Override
	      public int compare(int[] o1, int[] o2){
	        return o1[0] - o2[0];
	      }      
	    });
	    PriorityQueue<Integer> heap = new PriorityQueue<>();
	    for (int[] itv : intervals) {
	    	if (heap.isEmpty()) {
	    		cnt++;
	    		heap.offer(itv[1]);
	    	}else {
	    		if (itv[0] >= heap.peek()) {
	    			heap.poll();
	    		}else {
	    			cnt++;
	    		}
	    		heap.offer(itv[1]);	    			
	    	}
	    }	    
	    return cnt;
	}
	public int minMeetingRoomsTwoArraysTwoPointers(int[][] intervals) {
		// Write your solution here
		int cnt = 0;
		if (intervals == null)
			return cnt;
		// step 1: sort the start time and end time of all the meetings in two array, compare with two pointers i for start and j for end,
		// if i is smaller than j, meaning new meeting start time earlier than cur end time, room++ , i++
		// if i is bigger than j, meaning cur meeting finish before new meeting start, room--, j++
		// room global max
		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];
		for(int i = 0; i < intervals.length; i++){
			start[i] = intervals[i][0];
			end[i] = intervals[i][1];
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int i = 0;
		int j = 0;
		int room = 0;
		int globalRoom = 0;
		while(i < intervals.length && j < intervals.length){
			if(start[i] < end[j]){
				room++;
				i++;
				globalRoom = Math.max(globalRoom, room);
			}else{
				room--;
				j++;
			}
		}
		return globalRoom;
	}

	public int minMeetingRoomsTreeMap(int[][] intervals) {
		// Write your solution here
		int cnt = 0;
		if (intervals == null)
			return cnt;
		// use a treemap to sort all the start and end time of meetings, every start time need to plus 1 meeting room
		// every end time need decrease 1 meeting room, get the max room
		Map<Integer,Integer> map = new TreeMap<>();
		for(int[] cur : intervals){
			map.put(cur[0], map.getOrDefault(cur[0],0) + 1);
			map.put(cur[1], map.getOrDefault(cur[1],0) - 1);
		}
		int globalRoom = 0;
		for(Integer room : map.values()){
			cnt += room;
			globalRoom = Math.max(globalRoom, cnt);
		}
		return globalRoom;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MeetingRooms494Lai meetingRooms494Lai = new MeetingRooms494Lai();
		int[][] intervals =  {{14,33},{12,14},{19,31},{9,24},{19,26},{13,16},{15,31},{23,44},{4,24},{9,31},{18,40}};
		System.out.println(meetingRooms494Lai.minMeetingRoomsStack(intervals));
		System.out.println(meetingRooms494Lai.minMeetingRoomsTwoArraysTwoPointers(intervals));
		System.out.println(meetingRooms494Lai.minMeetingRoomsTreeMap(intervals));
	}

}
