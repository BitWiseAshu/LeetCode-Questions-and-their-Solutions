// Recursion solution

/*
class Solution {
    
    public int maxProfitHelper(int []prices, int index, int buy, int n){
        if(index == n){
            return 0;
        }
        
        int take = 0;
        int notTake = 0;
        
        // we can buy if buy == 1
        if(buy == 1){
            take = -prices[index] + maxProfitHelper(prices, index+1, 0, n); // if you buy
            notTake = 0 + maxProfitHelper(prices, index+1, 1, n); // if u not buy
        }
        
        // We can sell if buy == 0
        if(buy == 0){
            take = prices[index] + maxProfitHelper(prices, index+1, 1, n); //  Sell and move to next day with buy = 1
            notTake = 0 + maxProfitHelper(prices, index+1, 0, n); // Skip selling and move to next day with buy = 0
        }
        
        return Math.max(take, notTake);
    }
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        return maxProfitHelper(prices, 0, 1, n);
    }
}
*/





// Memoization
/*
class Solution {
    
    public int maxProfitHelper(int []prices, int index, int buy, int n, int [][]dp){
        if(index == n){
            return 0;
        }
        
        if(dp[index][buy] != -1){
            return dp[index][buy];
        }
        
        int take = 0;
        int notTake = 0;
        
        // we can buy if buy == 1
        if(buy == 1){
            take = -prices[index] + maxProfitHelper(prices, index+1, 0, n, dp); // if you buy
            notTake = 0 + maxProfitHelper(prices, index+1, 1, n, dp); // if u not buy
        }
        
        // We can sell if buy == 0
        if(buy == 0){
            take = prices[index] + maxProfitHelper(prices, index+1, 1, n, dp); //  Sell and move to next day with buy = 1
            notTake = 0 + maxProfitHelper(prices, index+1, 0, n, dp); // Skip selling and move to next day with buy = 0
        }
        
        dp[index][buy] = Math.max(take, notTake);
        return dp[index][buy];
    }
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        
        for(int []arr : dp){
            Arrays.fill(arr, -1);
        }
        
        return maxProfitHelper(prices, 0, 1, n, dp);
    }
}
*/





// Tabulation


class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        // Base case: If we are at the last index, profit is 0 as there's no day left to make any transactions
        dp[n][0] = dp[n][1] = 0;

        // Fill the dp table from the second last day to the first day
        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                int take, notTake;

                if (buy == 1) {
                    // If buy == 1, we have the option to buy the stock
                    take = -prices[index] + dp[index + 1][0];
                    notTake = dp[index + 1][1];
                } else {
                    // If buy == 0, we have the option to sell the stock
                    take = prices[index] + dp[index + 1][1];
                    notTake = dp[index + 1][0];
                }

                dp[index][buy] = Math.max(take, notTake);
            }
        }

        // The answer will be in dp[0][1] as it means we start on the first day with the ability to buy
        return dp[0][1];
    }
}
