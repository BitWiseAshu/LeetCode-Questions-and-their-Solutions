// Memoization approach
class Solution {
    
    public int uniquePathsUsingMemoization(int i, int j, int [][]dp){
        if(i == 0 && j == 0){
            return 1;
        }
        
        if(i < 0 || j < 0){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int up = uniquePathsUsingMemoization(i-1, j, dp);
        int down = uniquePathsUsingMemoization(i, j-1,dp);
        
        dp[i][j] = up+down;
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        int [][]dp = new int[m][n];
        
        for(int []arr : dp){
            Arrays.fill(arr, -1);
        }
        
        return uniquePathsUsingMemoization(m-1, n-1, dp);
    }
}