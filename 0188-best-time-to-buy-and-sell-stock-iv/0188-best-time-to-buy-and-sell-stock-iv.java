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
            // Try to buy at this index
            take = -prices[index] + maxProfitHelper(k, prices, n, index + 1, 0, dp);
            // Skip buying at this index
            notTake = maxProfitHelper(k, prices, n, index + 1, 1, dp);
        } else {
            // Try to sell at this index
            take = prices[index] + maxProfitHelper(k - 1, prices, n, index + 1, 1, dp);
            // Skip selling at this index
            notTake = maxProfitHelper(k, prices, n, index + 1, 0, dp);
        }
        
        dp[index][canBuy][k] = Math.max(take, notTake);
        return dp[index][canBuy][k];
    }

    public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[prices.length][2][k + 1]; // Notice k + 1 here to handle the index properly
        
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int m = 0; m < k + 1; m++) {  // Initialize all values to -1
                    dp[i][j][m] = -1;
                }
            }
        }
        
        return maxProfitHelper(k, prices, prices.length, 0, 1, dp);
    }
}
