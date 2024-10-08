class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        int ans = helper(coins, coins.length - 1, amount, dp);
        return ans == (int)1e9 ? -1 : ans;
    }

    private int helper(int[] coins, int index, int amount, int[][] dp) {
        if(index == 0) {
            if(amount % coins[index] == 0) return amount / coins[index];
            else return (int)1e9;
        }

        if(dp[index][amount] != -1){
            return dp[index][amount];
        }

        int take = Integer.MAX_VALUE;
        if(coins[index] <= amount) {
            take = 1 + helper(coins, index, amount - coins[index], dp);
        }
        
        int notTake = helper(coins, index - 1, amount, dp);

        return dp[index][amount] = Math.min(take, notTake);
    }
}