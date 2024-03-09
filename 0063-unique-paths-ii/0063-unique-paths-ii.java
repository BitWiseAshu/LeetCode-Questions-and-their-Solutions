class Solution {
    
    public int uniquePathsWithObstaclesUsingMemoization(int i, int j, int [][]dp, int [][]obstacleGrid){
        if(i == 0&& j == 0){
            if(obstacleGrid[i][j] == 1){
                return 0;
            }
            return 1;
        }
        
        if(i < 0 || j < 0){
            return 0;
        }
        
        if(obstacleGrid[i][j] == 1){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int up = uniquePathsWithObstaclesUsingMemoization(i-1, j, dp, obstacleGrid);
        int down = uniquePathsWithObstaclesUsingMemoization(i, j-1, dp, obstacleGrid);
        
        dp[i][j] = up + down;
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][]dp = new int[m][n];
        
        for(int []arr : dp){
            Arrays.fill(arr, -1);
        }
        
        return uniquePathsWithObstaclesUsingMemoization(m-1, n-1, dp, obstacleGrid);
    }
}