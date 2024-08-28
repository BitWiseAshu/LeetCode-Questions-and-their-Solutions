// memoization 

/*
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
*/



// tabulation
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int dp[][]=new int[n+1][2];
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                if(buy == 1){
                    dp[i][buy] = Math.max(-prices[i]+dp[i+1][0], dp[i+1][1]);
                }

                if(buy==0){
                    dp[i][buy] = Math.max((prices[i]+dp[i+1][1]) - fee, dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
        
    }
}
