package BFSHeap;
import OOD.OverRide;

import java.util.*;
/*
430. Course Schedule II
Medium
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 */
public class CourseScheduleII {

    // TC: O(V+E) SC: O(V+E) + O(V)
    // Highlevel: topological sort
    // step1: count all the preRequisite courses and incoming degree of every course
    // step2: use a queue to traverse the courses: expansion and generation
    public int[] topologicalArray( int numCourses, int[][] preRequisites){
        int[] res = new int[numCourses];
        int[] incomingDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        // initialize the graph
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        Queue<Integer> queue = new ArrayDeque<>();
        // step1: count all the preRequisite courses
        for(int[] dependency: preRequisites){
            int next = dependency[0];
            int prev = dependency[1];
            incomingDegree[next]++;
            graph.get(prev).add(next);
        }
        // step 2: traverse all the courses,// 把入度为0的课程放入queue
        for(int i = 0; i < numCourses; i++){
            if(incomingDegree[i] == 0){
                queue.offer(i);
            }
        }
        int index = 0;
        while(!queue.isEmpty()){
            Integer cur = queue.poll();
            res[index++] = cur;
            for(int a : graph.get(cur)){
                incomingDegree[a]--;
                if(incomingDegree[a] == 0){
                    queue.offer(a);
                }
            }
        }
        return index == numCourses ? res : new int[0];
    }
    // Method 2: 用HashMap记录所有课程和对应预修课，Set放预修课集合
    // highlevel: topological
    // assumption: input is valid
    // step1: count all the preCourse with a HashMap, key is course, value is a set of this preRequisite courses of this course
    // step2: offer all the course which don't have a preRequisite course into a queue, expand the queue(add to result) while it is not empty,
    // generation the course by remove the preRequisite course of current course, offer them to queue
    // step3: until all the course have been expansion.
    // TC: O(V+E)  SC: O(V+E)+O(V)
    public int[] topologicalHashMap( int numCourses, int[][] prerequisites){
        int[] res = new int[numCourses];
        if(prerequisites == null || prerequisites.length == 0){
            return res;
        }
        // step1: count all preRequisite Course with a map,
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] pre : prerequisites){
            if(map.containsKey(pre[0])){
                map.get(pre[0]).add(pre[1]);
            }else{
                map.put(pre[0], new HashSet<>(Arrays.asList(pre[1])));
            }
        }
        // step2: offer all the course which don't have preRequisite courses
        // expansion 课程，expand出来的都是没有先修课程的，可以直接加入结果队列。
        // 找出来后，把以当前cur为先修课的其余课程的先修set中去掉cur，如果去完为空说明可以修了，generate到queue里
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(map.get(i) == null){
                queue.offer(i);
            }
        }
        //step3: expansion and generation all the course:
        int index = 0;
        while(!queue.isEmpty()){
            Integer cur = queue.poll();
            res[index++] = cur;
            for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()){
                Set<Integer> set = entry.getValue();
                if(set.contains(cur)){
                    set.remove(cur);
                    if(set.isEmpty()){
                        queue.offer(entry.getKey());
                    }
                }
               }
            }
        return index == numCourses ? res : new int[0];
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
            // highlevel: traverse pre[][], store pre for each course, store them into a int[] = indegree[]
            //traverse again, find which indegree is 0, then find which course has this pre, indegree[x]--
            int[] indegree = new int[numCourses];

            // initialize the graph
            List<List<Integer>> graph = new ArrayList<>(numCourses);
            for(int i = 0; i < numCourses; i++){
                graph.add(new ArrayList<>());
            }

            // traverse the pre[][], to add all the pre course into the listOfList, meanwhile update indegree
            for(int[] pre : prerequisites){
                int x = pre[0];
                int y  = pre[1];
                graph.get(y).add(x);
                indegree[x]++;
            }

            // put all the  store all the course that have no pre course into a queue,
            Queue<Integer> queue = new ArrayDeque<>();
            for(int i = 0; i < numCourses; i++){
                if(indegree[i] == 0){
                    queue.offer(i);
                }
            }
            // BFS, generate all the courses from queue and expant all the course depend on those courses

            while(!queue.isEmpty()){
                Integer cur = queue.poll();
                for(Integer next : graph.get(cur)){
                    indegree[next]--;
                    if(indegree[next] == 0){
                        queue.offer(next);
                    }
                }
            }
            // if queue is empty, meaning all the courses
            for(int i = 0; i < numCourses; i++){
                if(indegree[i] != 0){
                    return false;
                }
            }

            return true;

        }


    public static void main(String[] args) {
        CourseScheduleII course = new CourseScheduleII();
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2},{1,2}};
        int[][] pre = {{1,0},{2,0},{3,1},{3,2},{2,3}};
//        System.out.println(Arrays.toString(course.findOrder(4,prerequisites)));
//        System.out.println("findOrderII"  + Arrays.toString(course.findOrderII(4,prerequisites)));
        System.out.println("topological" + Arrays.toString(course.topologicalArray(4,prerequisites)));
        List<Integer> a = Arrays.asList(1,2);
        System.out.println(a);
        int numCourses = 2;
        int[][] prerequisites1 =  {{1,0}};
        System.out.println(course.canFinish(numCourses,prerequisites1));
    }
}
