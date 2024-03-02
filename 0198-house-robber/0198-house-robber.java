class Solution {
    // 1st solution
    /*
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int dp[] = new int[n];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < n; i++){
            dp[i] =Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        
        return dp[n-1];
    }
    */
    
    
    // 2nd solution
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        
        int ans = robHelper(n-1, nums, dp);
        return ans;
    }
    
    public int robHelper(int n, int []nums, int []dp){
        if(n < 0){
            return 0;
        }
        
        if(n == 0){
            return nums[n];
        }
        
        if (dp[n] != -1) return dp[n];
        
        // Calculate the maximum sum by either picking the current element or not picking it.
        int pick = nums[n] + robHelper(n - 2, nums, dp);
        // System.out.println("picked "+ pick + " n " + n);
        int nonPick = robHelper(n - 1, nums, dp);
        // System.out.println("non-picked"+ nonPick+" n " + n);
        
        dp[n] = Math.max(pick, nonPick);
        return dp[n];
    }
    
}