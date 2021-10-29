package DynamicPrograming;

import java.util.Arrays;
import java.util.TreeMap;

/**
 *We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
 *
 * You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
 *
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 *
 Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 Output: 120
 Explanation: The subset chosen is the first and fourth job.
 Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
 */
public class MaxProfit {
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i=0;i<startTime.length; i++) {
            jobs[i] = new int[] {startTime[i],endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        TreeMap<Integer, Integer> resultTree = new TreeMap<>();
        resultTree.put(0,0);
        for (int[] job : jobs) {
            int val = job [2] + resultTree.floorEntry(job[0]).getValue();
            if (val > resultTree.lastEntry().getValue()) {
                resultTree.put(job[1], val);
            }
        }
        return resultTree.lastEntry().getValue();
    }
    public static void main(String args[]){
        System.out.println(jobScheduling(new int[]{1,2,3,3}, new int[]{3,4,5,6}, new int[] {50,10,40,70}));
    }
}
