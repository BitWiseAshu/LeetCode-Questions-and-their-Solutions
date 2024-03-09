// Memoization approach
/*

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
*/




// Tabulation approach

class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][]dp = new int[m][n];
        
        for(int []arr : dp){
            Arrays.fill(arr, -1);
        }
        
        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                
                int down = 0;
                int right = 0;

                if (i > 0) down = dp[i - 1][j];
                
                if (j > 0) right = dp[i][j - 1];
                
                dp[i][j] = down + right;
            }
        }
        return dp[m-1][n-1];
    }
}