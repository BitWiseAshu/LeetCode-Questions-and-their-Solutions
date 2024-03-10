/*
class Solution {

    public boolean isValid(int i, int j, int[][] arr) {
        return i >= 0 && j >= 0 && i < arr.length && j < arr[0].length;
    }

    public int minPathSum(int[][] grid) {

        int i = 0;
        int j = 0;

        int sum = 0;

        while (isValid(i, j, grid)) {
            int right = 0;
            int down = 0;

            if (isValid(i, j + 1, grid)) {
                right = grid[i][j + 1];
            }

            if (isValid(i + 1, j, grid)) {
                down = grid[i + 1][j];
            }

            if (right < down) {
                j = j + 1;
                sum += right;
            } else {
                i = i + 1;
                sum += down;
            }
        }
        return sum;
    }
}
*/



// Recursive Approach
/*
class Solution {

    public boolean isValid(int i, int j, int[][] arr) {
        return i >= 0 && j >= 0 && i < arr.length && j < arr[0].length;
    }
    
    public int minPathSumUsingRecursion(int i, int j, int [][]grid){
        if(i == grid.length-1 && j == grid[0].length-1){
            return grid[grid.length-1][grid[0].length-1];
        }
        
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return Integer.MAX_VALUE;
        }
        
        int right = minPathSumUsingRecursion(i, j+1, grid);
        int down = minPathSumUsingRecursion(i+1, j, grid);
        
        int minPath = Math.min(right, down)+ grid[i][j];
        return minPath;
    }

    public int minPathSum(int[][] grid) {
        return minPathSumUsingRecursion(0, 0, grid);
    }
}
*/





// Memoization Approach
/*
class Solution {
    
    public int minPathSumUsingMemoization(int i, int j, int [][]grid, int [][]dp){
        if(i == 0 && j == 0){
            return grid[0][0];
        }
        
        if(i < 0 || j < 0){
            return 10000000; // return larger value
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int up = grid[i][j] + minPathSumUsingMemoization(i-1, j, grid, dp);
        int left = grid[i][j] + minPathSumUsingMemoization(i, j-1, grid, dp);
        
        int min = Math.min(up, left);
        dp[i][j] = min;
        
        return dp[i][j];
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int dp[][] = new int[n][m];
        for(int []arr : dp){
            Arrays.fill(arr, -1);
        }
        
        return minPathSumUsingMemoization(n-1, m-1, grid, dp);
    }
}

*/









// Tabulation approach

class Solution {

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int dp[][] = new int[n][m];
        
        for(int i = 0  ; i < n; i++){
            for(int j = 0 ;  j < m ; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                    continue;
                }
                
                int right = grid[i][j];
                if(j > 0){
                    right += dp[i][j-1];
                }
                else{
                    right += 10000000;
                }
                
                
                int down = grid[i][j];
                if(i > 0){
                    down += dp[i-1][j];
                }
                else{
                    down += 10000000;
                }
                
                dp[i][j] = Math.min(right, down);
            }
        }
        return dp[n-1][m-1];
    }
}

