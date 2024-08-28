// recursive approach

/*
class Solution {
    
    public int maxProfitHelper(int []prices, int index, int n, int capacity, int canBuy){
        if(index == n) {
            return 0;
        }
        
        if(capacity == 0) {
            return 0;
        }
        
        int take = 0;
        int notTake = 0;
        
        // we can buy
        if(canBuy == 1){
            take = -prices[index] + maxProfitHelper(prices, index+1, n, capacity, 0); // if you buy
            notTake = maxProfitHelper(prices, index+1, n, capacity, 1); // if you not buy
        }
        
        // we can sell
        if(canBuy == 0){
            take = prices[index] + maxProfitHelper(prices, index+1, n, capacity-1, 1); // Sell and move to next day with buy = 1
            notTake = maxProfitHelper(prices, index+1, n, capacity, 0); // Skip selling and move to next day with buy = 0
        }
        
        return Math.max(take, notTake);
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        return maxProfitHelper(prices, 0, n, 2, 1);
    }
}
*/


// Memoization approach
/*
class Solution {
    
    public int maxProfitHelper(int []prices, int index, int n, int capacity, int canBuy, int [][][]dp){
        if(index == n) {
            return 0;
        }
        
        if(capacity == 0) {
            return 0;
        }
        
        if(dp[index][canBuy][capacity] != -1){
            return dp[index][canBuy][capacity];
        }
        
        int take = 0;
        int notTake = 0;
        
        // we can buy
        if(canBuy == 1){
            take = -prices[index] + maxProfitHelper(prices, index+1, n, capacity, 0, dp); // if you buy
            notTake = maxProfitHelper(prices, index+1, n, capacity, 1, dp); // if you not buy
        }
        
        // we can sell
        if(canBuy == 0){
            take = prices[index] + maxProfitHelper(prices, index+1, n, capacity-1, 1, dp); // Sell and move to next day with buy = 1
            notTake = maxProfitHelper(prices, index+1, n, capacity, 0, dp); // Skip selling and move to next day with buy = 0
        }
        
        dp[index][canBuy][capacity] = Math.max(take, notTake);
        return dp[index][canBuy][capacity];
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int dp[][][] = new int[n][2][3];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return maxProfitHelper(prices, 0, n, 2, 1, dp);
    }
}
*/




// Tabulation


class Solution {
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int dp[][][] = new int[n+1][2][3];
        
        // Initialize the base cases
        for (int i = 0; i <= n; i++) {
            for (int buy = 0; buy < 2; buy++) {
                dp[i][buy][0] = 0; // No profit can be made with 0 capacity left
            }
        }

        for(int index = n-1; index >= 0; index--){
            for(int buy = 0; buy < 2; buy++){
                for(int capacity = 1; capacity < 3 ; capacity++){
                    if(buy == 1){ // we can buy 
                        dp[index][buy][capacity] = Math.max(-prices[index] + dp[index+1][0][capacity], dp[index+1][1][capacity]);
                    } else { // we can sell
                        dp[index][buy][capacity] = Math.max(prices[index] + dp[index+1][1][capacity-1], dp[index+1][0][capacity]);
                    }
                }
            }
        }
        
        return dp[0][1][2];
    }
}