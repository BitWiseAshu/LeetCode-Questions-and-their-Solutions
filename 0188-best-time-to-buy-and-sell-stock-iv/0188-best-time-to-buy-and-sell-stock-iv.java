// Recursion

/*
class Solution {
    
    public int maxProfitHelper(int k, int []prices, int n, int index, int canBuy){
        if(index == n || k == 0){
            return 0;
        }
        
        int take = 0;
        int notTake = 0;
        
        if(canBuy == 1){
            take = -prices[index] + maxProfitHelper(k, prices, n, index+1, 0);
            notTake = maxProfitHelper(k, prices, n, index+1, 1);
        }
        
        if(canBuy == 0){
            take = prices[index] + maxProfitHelper(k-1, prices, n, index+1, 1);
            notTake = maxProfitHelper(k, prices, n, index+1, 0);
        }
        
        return Math.max(take, notTake);
    }
    public int maxProfit(int k, int[] prices) {
        return maxProfitHelper(k, prices, prices.length, 0, 1);
    }
}
*/





// Memoization 

/*
class Solution {

    public int maxProfitHelper(int k, int[] prices, int n, int index, int canBuy, int[][][] dp) {
        if (index == n || k == 0) {
            return 0;
        }
        
        int take = 0;
        int notTake = 0;
        
        if (dp[index][canBuy][k] != -1) {
            return dp[index][canBuy][k];
        }
        
        if (canBuy == 1) {
            take = -prices[index] + maxProfitHelper(k, prices, n, index + 1, 0, dp);
            notTake = maxProfitHelper(k, prices, n, index + 1, 1, dp);
        } else {
            take = prices[index] + maxProfitHelper(k - 1, prices, n, index + 1, 1, dp);
            notTake = maxProfitHelper(k, prices, n, index + 1, 0, dp);
        }
        
        dp[index][canBuy][k] = Math.max(take, notTake);
        return dp[index][canBuy][k];
    }

    public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[prices.length][2][k + 1]; // Notice k + 1 here to handle the index properly
        
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int m = 0; m < k + 1; m++) {
                    dp[i][j][m] = -1;
                }
            }
        }
        
        return maxProfitHelper(k, prices, prices.length, 0, 1, dp);
    }
}
*/








// Tabulation
class Solution {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int dp[][][] = new int[n + 1][2][k + 1]; 

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j][0] = 0; // No transactions left, profit is 0
            }
        }
     
        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                for (int capacity = 1; capacity <= k; capacity++) { // Capacity starts from 1
                    if (canBuy == 1) { // We can buy
                        dp[index][canBuy][capacity] = Math.max(
                            -prices[index] + dp[index + 1][0][capacity], // Buy and move to the next day
                            dp[index + 1][1][capacity]                  // Skip buying
                        );
                    } else { // We can sell
                        dp[index][canBuy][capacity] = Math.max(
                            prices[index] + dp[index + 1][1][capacity - 1], // Sell and move to the next day
                            dp[index + 1][0][capacity]                     // Skip selling
                        );
                    }
                }
            }
        }
        
        // The answer is dp[0][1][k], starting on day 0 with the ability to buy and k transactions left
        return dp[0][1][k];
    }
}
