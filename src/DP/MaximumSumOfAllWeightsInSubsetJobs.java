package DP;

import ArrayMatrix.MaximumSumSubarray;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Given N sections where every section is represented by the following three elements:
1. Start time
2. Finish time
3. Weight
Find the maximum sum of all weights in a subset of jobs such that no two sections in the subset overlap with each other
 Example:
 Input: Number of Jobs n = 4
 Job Details{Start time, Finish Time, Weight}
 Job 1: {1,2,50}
 Job 2: {3,5,20}
 Job 3: {6,19,100}
 Job 4: {2,100,200}
 OUtput : 250 , job1 and job 4
 */
/*
C: (1)does the jobs sorted?  (2)does the jobs edges are included?
A: There are at least one job
R: DP: dop[i] represents till job[i](included), the maximum sum of weights endings at jobs[i]
T: TC: O(n), SC: O(n)
 */
public class MaximumSumOfAllWeightsInSubsetJobs {
    class Job{
        int start;
        int finish;
        int weight;
        public Job(int start, int finish, int weight){
            this.start = start;
            this.finish = finish;
            this.weight = weight;
        }
    }
    // Highlevel : DP
    // step 1: sort the jobs based on start time
    // step 2: traverse the jobs, and calculate the maximum sum of weights ending at job[i]
    // step 3: return dp[i]
    public int maximumSum(Job[] jobs){
        Arrays.sort(jobs, new Comparator<Job>(){
            @Override
            public int compare(Job o1, Job o2) {
                if (o1.start == o2.start) {
                    return 0;
                } else {
                    return o1.start - o2.start;
                }
            }
        });
        int[] dp = new int[jobs.length];
        int globalMax = 0;
        // base case
        dp[0] = jobs[0].weight;
        System.out.println("dp[0]: " + dp[0]);
        for(int i = 1; i < jobs.length; i++){
            for(int j = 0; j < i; j++){
                if(jobs[j].finish <= jobs[i].start){
                    dp[i] = Math.max(dp[i],dp[j] + jobs[i].weight);
                    System.out.println("dp[i]: " + dp[i]);
                }
            }
            globalMax = Math.max(globalMax,dp[i]);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        MaximumSumOfAllWeightsInSubsetJobs maximumSumOfAllWeightsInSubsetJobs = new MaximumSumOfAllWeightsInSubsetJobs();
        Job Job1 = maximumSumOfAllWeightsInSubsetJobs.new Job(1,2,50);
        Job Job2 = maximumSumOfAllWeightsInSubsetJobs.new Job(3,5,20);
        Job[] jobs = {
                Job1,Job2,
                maximumSumOfAllWeightsInSubsetJobs.new Job(6,19,100), maximumSumOfAllWeightsInSubsetJobs.new Job(2,100,200)
        };
        for(Job job: jobs){
            System.out.println("job.start: " + job.start);
        }
        System.out.println(maximumSumOfAllWeightsInSubsetJobs.maximumSum(jobs));
    }

}
