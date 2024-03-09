// Memoization approach
/*
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
*/


// Recursion Approach
/*
class Solution {
    
    public int uniquePathsUsingMemoization(int i, int j){
        if(i == 0 && j == 0){
            return 1;
        }
        
        if(i < 0 || j < 0){
            return 0;
        }
        
        int up = uniquePathsUsingMemoization(i-1, j);
        int down = uniquePathsUsingMemoization(i, j-1);
        
        return up+down;
    }
    public int uniquePaths(int m, int n) {
        
        return uniquePathsUsingMemoization(m-1, n-1);
    }
}
*/




// Tabulation approach
/*
class Solution {
    
    public int uniquePaths(int m, int n) {
        int [][]dp = new int[m][n];
        
        for(int []arr : dp){
            Arrays.fill(arr, -1);
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                
                int up = 0;
                int left = 0;
                
                if(i > 0 && i < m){
                    up = dp[i-1][j];
                }
                if(j > 0 && j < n){
                    left = dp[i][j-1];
                }
                
                dp[i][j] = up + left;
            }
        }
        
        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         System.out.print(dp[i][j]+ " ");
        //     }
        //     System.out.println();
        // }
        
        return dp[m-1][n-1];
    }
}
*/




// Space optimization 

class Solution {
    
    public int uniquePaths(int m, int n) {
        int []prev = new int[n];
        
        for (int i = 0; i < m; i++) {
            // Create a temporary array to store the results for the current row
            int temp[] = new int[n];
            
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    // Base condition: There's one way to reach the top-left cell (0, 0)
                    temp[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                // Calculate the number of ways by moving up (if possible) and left (if possible)
                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = temp[j - 1];

                // Store the total number of ways to reach the current cell in the temporary array
                temp[j] = up + left;
            }
            
            // Set the temporary array as the previous array for the next row
            prev = temp;
        }

        // Return the number of ways to reach the bottom-right cell (m-1, n-1)
        return prev[n - 1];
    }
}