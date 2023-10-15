class Solution {
    public int numWays(int steps, int arrLen) {
        int m = (int) 1e9 + 7;
        arrLen = Math.min(arrLen, steps);
        int[][] dp = new int[arrLen][steps + 1];
        dp[0][0] = 1;
        int ans;
        for (int remain = 1; remain <= steps; remain++) {
            for (int curr = 0; curr<arrLen; curr++) {
                ans = dp[curr][remain - 1];
                if (curr > 0) {
                    ans = (ans + dp[curr - 1][remain - 1]) % m;
                }
                
                if (curr < arrLen - 1) {
                    ans = (ans + dp[curr + 1][remain - 1]) % m;
                }
                
                dp[curr][remain] = ans;
            }
        }       
        return dp[0][steps];
    }
    
    
    // This is also the right solution but it gives time limit Exceed
    /*
    public int numWays(int steps, int arrLen) {
        int MOD = 1000000007;
        int maxPosition = Math.min(steps / 2, arrLen - 1);
        
        // Create a memoization array to store previously computed results
        int[][] memo = new int[steps + 1][maxPosition + 1];
        
        // Call the recursive helper function
        return helper(steps, 0, maxPosition, memo, MOD);
    }
    
    private int helper(int steps, int position, int maxPosition, int[][] memo, int MOD) {
        // Base cases
        if (steps == 0) {
            return (position == 0) ? 1 : 0;
        }
        if (position < 0 || position > maxPosition) {
            return 0;
        }
        
        // Check if the result is already computed
        if (memo[steps][position] != 0) {
            return memo[steps][position];
        }
        
        // Calculate the number of ways recursively
        int ways = helper(steps - 1, position, maxPosition, memo, MOD); // Stay in the same place
        ways = (ways + helper(steps - 1, position - 1, maxPosition, memo, MOD)) % MOD; // Move one step to the left
        ways = (ways + helper(steps - 1, position + 1, maxPosition, memo, MOD)) % MOD; // Move one step to the right
        
        // Store the result in the memoization array and return it
        memo[steps][position] = ways;
        return ways;
    }
    */
}