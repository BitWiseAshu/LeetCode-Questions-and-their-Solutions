class Solution {
    
    public int maxProfitHelper(int []prices, int index, int buy, int n, int [][]dp, int fee){
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
            take = -prices[index] + maxProfitHelper(prices, index+1, 0, n, dp, fee); // if you buy
            notTake = 0 + maxProfitHelper(prices, index+1, 1, n, dp, fee); // if u not buy
        }
        
        // We can sell if buy == 0
        if(buy == 0){
            take = prices[index] - fee + maxProfitHelper(prices, index+1, 1, n, dp, fee); //  Sell and move to next day with buy = 1
            notTake = 0 + maxProfitHelper(prices, index+1, 0, n, dp, fee); // Skip selling and move to next day with buy = 0
        }
        
        dp[index][buy] = Math.max(take, notTake);
        return dp[index][buy];
    }
    
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        
        for(int []arr : dp){
            Arrays.fill(arr, -1);
        }
        
        return maxProfitHelper(prices, 0, 1, n, dp, fee);
    }
}