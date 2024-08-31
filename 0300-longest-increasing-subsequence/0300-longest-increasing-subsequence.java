// Recursion 

/*
class Solution {
    
    public int helper(int []nums, int index, int prevIndex, int n){
        if(index == n){
            return 0;
        }
        
        int take = 0;
        if(prevIndex == -1 || nums[index] > nums[prevIndex]){
            take = 1 + helper(nums, index + 1, index, n);
        }
        
        int notTake = helper(nums, index+1, prevIndex, n);
        
        return Math.max(take, notTake);
        
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        return helper(nums, 0, -1, n);
    }
}
*/





// Memoization Solution 

class Solution {
    
    public int helper(int []nums, int index, int prevIndex, int n, int dp[][]){
        if(index == n){
            return 0;
        }
        
        if(dp[index][prevIndex+1] != -1){
            return dp[index][prevIndex+1];
        }
        
        int take = 0;
        if(prevIndex == -1 || nums[index] > nums[prevIndex]){
            take = 1 + helper(nums, index + 1, index, n, dp);
        }
        
        int notTake = helper(nums, index+1, prevIndex, n, dp);
        
        dp[index][prevIndex+1] = Math.max(take, notTake);
        return dp[index][prevIndex+1];
        
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        int dp[][] = new int[n][n+1];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        
        return helper(nums, 0, -1, n, dp);
    }
}








/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = Arrays.stream(dp).max().orElse(0);
        return maxLength;
    }
}
*/
