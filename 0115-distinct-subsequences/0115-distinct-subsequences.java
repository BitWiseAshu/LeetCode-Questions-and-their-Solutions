// Recursion solution

/*
class Solution {
    
    public int numDistinctHelper(String s, String t, int i, int n, String str){
        if(i == n){
            if(str.equals(t)){
                return 1;
            }
            else{
                return 0;
            }
        }
        
        int take = numDistinctHelper(s, t, i+1, n, str+s.charAt(i));
        int notTake = numDistinctHelper(s, t, i+1, n, str);
        
        return take + notTake;
    }
    
    public int numDistinct(String s, String t) {
        return numDistinctHelper(s, t, 0, s.length(), "");
    }
}
*/



// memoization 
/*
class Solution {
    
    public int numDistinctHelper(String s, String t, int i, int j, int n, int m, int [][]dp){
        if(j == m) {
            return 1; // Successfully matched all characters of t
        }
        
        if(i == n) {
            return 0; // Reached the end of s without fully matching t
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int take = 0;
        if(s.charAt(i) == t.charAt(j)) {
            take = numDistinctHelper(s, t, i+1, j+1, n, m, dp);
        }
        
        int notTake = numDistinctHelper(s, t, i+1, j, n, m, dp);
        
        dp[i][j] = take + notTake;
        
        return dp[i][j];
    }
    
    public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length()][t.length()];
        
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        
        return numDistinctHelper(s, t, 0, 0, s.length(), t.length(), dp);
    }
}
*/





// Tabulation 

class Solution {

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        // dp[i][j] will store the count of distinct subsequences of t[0...j-1] in s[0...i-1]
        int dp[][] = new int[n + 1][m + 1];

        // Base case: An empty string t can be found once in any prefix of s, so initialize dp[i][0] = 1
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // If characters match, include both possibilities: 
                    // 1. Include the current character from s (dp[i-1][j-1])
                    // 2. Exclude the current character from s (dp[i-1][j])
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // If characters don't match, only exclude the current character from s
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The answer is stored in dp[n][m]
        return dp[n][m];
    }
}
