// Recursive Solution

/*
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int ans = minDistanceHelper(word1, word2, n, m, 0, 0);
        
        return ((n-ans) + (m-ans));
    }
    
    public int minDistanceHelper(String word1, String word2, int n, int m, int i, int j){
        if(i == n || j == m){
            return 0;
        }
        
        if(word1.charAt(i) == word2.charAt(j)){
            return 1 + minDistanceHelper(word1, word2, n, m, i+1, j+1);
        }
        else{
            return Math.max(minDistanceHelper(word1, word2, n, m, i+1, j), minDistanceHelper(word1, word2, n, m, i, j+1));
        }
    }
}
*/




// Memoization

/*
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int dp[][] = new int[n+1][m+1];
        
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        
        int ans = minDistanceHelper(word1, word2, n, m, 0, 0, dp);
        return ((n-ans) + (m-ans));
    }
    
    public int minDistanceHelper(String word1, String word2, int n, int m, int i, int j, int [][]dp){
        if(i == n || j == m){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(word1.charAt(i) == word2.charAt(j)){
             dp[i][j] = 1 + minDistanceHelper(word1, word2, n, m, i+1, j+1, dp);
        }
        else{
            dp[i][j] = Math.max(minDistanceHelper(word1, word2, n, m, i+1, j, dp), minDistanceHelper(word1, word2, n, m, i, j+1, dp));
        }
        
        return dp[i][j];
    }
}
*/



// Tabulation 




class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return (n - dp[n][m]) + (m - dp[n][m]); 
    }
}