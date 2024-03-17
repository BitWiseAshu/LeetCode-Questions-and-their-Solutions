// This  is a recursion solution and it gives time limit exceed

/*
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for(int i = 0 ; i  < nums.length; i++){
            sum += nums[i];
        }
        
        if(sum % 2 == 1){
            return false;
        }
        
        int target = sum/2;
        
        return canPartitionUsingRecursion(nums, target, nums.length-1);
    }
    
    public boolean canPartitionUsingRecursion(int []arr, int target, int n){
        
        if(target == 0){
            return true;
        }
        
        if(n == 0){
            return arr[0] == target;
        }
        
        boolean taken = canPartitionUsingRecursion(arr, target, n-1);
        
        boolean notTaken = false;
        if(target >= arr[n]){
            notTaken = canPartitionUsingRecursion(arr, target-arr[n], n-1);
        }
        
        return taken || notTaken;
    }
    
}

*/



// solution using memoization

/*
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for(int i = 0 ; i  < nums.length; i++){
            sum += nums[i];
        }
        
        if(sum % 2 == 1){
            return false;
        }
        
        int target = sum/2;
        
        boolean [][]dp = new boolean[nums.length][target+1];
        
        for(boolean []arr: dp){
            Arrays.fill(arr, false);
        }
        
        return canPartitionUsingMemoization(nums, target, nums.length-1, dp);
    }
    
    public boolean canPartitionUsingMemoization(int []arr, int target, int n, boolean dp[][]){
        
        if(target == 0){
            return true;
        }
        
        if(n == 0){
            return arr[0] == target;
        }
        
        if(dp[n][target] == true){
            return true;
        }
        
        boolean taken = canPartitionUsingMemoization(arr, target, n-1, dp);
        
        boolean notTaken = false;
        if(target >= arr[n]){
            notTaken = canPartitionUsingMemoization(arr, target-arr[n], n-1, dp);
        }
        
        return dp[n][target] = taken || notTaken;
    }
    
}
*/




// using tabulation

class Solution {
    public boolean canPartition(int[] arr) {
        // Calculate the total sum of the array elements
        int n = arr.length;
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        // If the total sum is odd, it cannot be partitioned into equal subsets
        if (totSum % 2 == 1) 
            return false;
        else {
            // Calculate the target sum for each subset
            int k = totSum / 2;
            // Create a DP table to store the results of subproblems
            boolean dp[][] = new boolean[n][k + 1];

            // Initialize the first row of the DP table
            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }

            // Initialize the first column of the DP table
            if (arr[0] <= k) {
                dp[0][arr[0]] = true;
            }

            // Fill in the DP table using bottom-up dynamic programming
            for (int ind = 1; ind < n; ind++) {
                for (int target = 1; target <= k; target++) {
                    // Calculate if the current element is not taken
                    boolean notTaken = dp[ind - 1][target];

                    // Calculate if the current element is taken
                    boolean taken = false;
                    if (arr[ind] <= target) {
                        taken = dp[ind - 1][target - arr[ind]];
                    }

                    // Update the DP table for the current element and target sum
                    dp[ind][target] = notTaken || taken;
                }
            }

            // The result is stored in the last cell of the DP table
            return dp[n - 1][k];
        }
    }
    
}