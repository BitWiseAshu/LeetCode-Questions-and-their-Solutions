// Recursion solution
/*
class Solution {
    
    public int changeHelper(int amount, int []coins, int index, int sum){
        if(index == coins.length){
            if(sum == amount){
                return 1;
            }
            else{
                return 0;
            }
        }
        
        if(sum > amount){
            return 0;
        }
        
        if(sum == amount){
            return 1;
        }
        
        int take = changeHelper(amount, coins, index, sum+coins[index]);
        int nonTake = changeHelper(amount, coins, index + 1, sum);
        
        return (take + nonTake);
    }
    
    public int change(int amount, int[] coins) {
        return changeHelper(amount, coins, 0, 0);
    }
}
*/






// memoization

/*
class Solution {
    
    public int changeHelper(int amount, int []coins, int index, int sum, int [][]dp){
        if(index == coins.length){
            if(sum == amount){
                return 1;
            }
            else{
                return 0;
            }
        }
        
        if(sum > amount){
            return 0;
        }
        
        if(sum == amount){
            return 1;
        }
        
        if(dp[index][sum] != -1){
            return dp[index][sum];
        }
        
        int take = changeHelper(amount, coins, index, sum+coins[index], dp);
        int nonTake = changeHelper(amount, coins, index + 1, sum, dp);
        
        dp[index][sum] = take + nonTake;
        return dp[index][sum];
    }
    
    public int change(int amount, int[] coins) {
        
        int[][] dp = new int[coins.length+1][amount + 1];
        
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        
        return changeHelper(amount, coins, 0, 0, dp);
    }
}

*/




// tabulation

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        
        // Base case: There is 1 way to make the amount 0 (by not using any coins)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                // Exclude the current coin
                dp[i][j] = dp[i - 1][j];
                
                // Include the current coin if j >= coins[i-1]
                if (j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        
        return dp[n][amount];
    }
}
