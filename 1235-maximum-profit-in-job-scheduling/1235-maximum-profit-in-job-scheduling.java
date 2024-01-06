import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        
        // Create an array of jobs
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        
        // Sort jobs based on their end times
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));
        
        // dp array to store the maximum profit at each index
        int[] dp = new int[n];
        dp[0] = jobs[0][2]; // The first job has the maximum profit
        
        for (int i = 1; i < n; i++) {
            int currentProfit = jobs[i][2];
            int prevIndex = binarySearch(jobs, i);
            if (prevIndex != -1) {
                currentProfit += dp[prevIndex];
            }
            dp[i] = Math.max(currentProfit, dp[i - 1]); // Choose the maximum profit
        }
        
        return dp[n - 1];
    }
    
    // Binary search to find the latest non-overlapping job
    private int binarySearch(int[][] jobs, int index) {
        int low = 0, high = index - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid][1] <= jobs[index][0]) {
                if (jobs[mid + 1][1] <= jobs[index][0]) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        
        return -1; // No non-overlapping job found
    }
}
