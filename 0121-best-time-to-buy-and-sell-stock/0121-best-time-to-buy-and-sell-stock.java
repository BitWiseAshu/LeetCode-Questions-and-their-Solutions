class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int finalMaxPrice = Integer.MIN_VALUE;
        int min = prices[0];
        
        for(int i = 1; i < n; i++){
            int ans = prices[i] - min;
            
            min = Math.min(min, prices[i]);
            finalMaxPrice = Math.max(finalMaxPrice, ans);
        }
        
        return finalMaxPrice < 0 ? 0 : finalMaxPrice;
    }
}