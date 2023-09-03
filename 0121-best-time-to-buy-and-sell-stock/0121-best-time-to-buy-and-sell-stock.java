class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int minNum = Integer.MAX_VALUE;
        int finalMaxPrice = 0;
        
        for(int i = 0 ; i < n; i++){
            int num = prices[i];
            
            if(num <= minNum){
                minNum = num;
            }
            
            int maxPrice = prices[i] - minNum;
            
            if(maxPrice > finalMaxPrice){
                finalMaxPrice = maxPrice;
            }
        }
        
        return finalMaxPrice;
    }
}