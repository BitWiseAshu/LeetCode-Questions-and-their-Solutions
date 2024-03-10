class Solution {
    
    public int minimumTotalUsingMemoization(int row, int col, List<List<Integer>> triangle, int [][]dp){
        if(row == triangle.size()-1){
            return triangle.get(row).get(col);
        }
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        int down = triangle.get(row).get(col) + minimumTotalUsingMemoization(row+1, col, triangle, dp);
        int downPlusOne = triangle.get(row).get(col) + minimumTotalUsingMemoization(row+1, col+1, triangle, dp);
        
        int minPath = Math.min(down, downPlusOne);
        dp[row][col] = minPath;
        
        return dp[row][col];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        int [][]dp = new int[n][n];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        
        return minimumTotalUsingMemoization(0, 0, triangle, dp);
    }
}