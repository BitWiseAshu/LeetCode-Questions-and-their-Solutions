// Using Recursion

/*
class Solution {
    
    public int longestCommonSubsequenceUsingRecursion(String text1, String text2, int i, int j, int n, int m){
        if(i == n || j == m){
            return 0;
        }
        
        if(text1.charAt(i) == text2.charAt(j)){
            return 1+longestCommonSubsequenceUsingRecursion(text1, text2, i+1, j+1, n, m);
        }
        else{
            int skipText1 = longestCommonSubsequenceUsingRecursion(text1, text2, i+1, j, n, m);
            int skipText2 = longestCommonSubsequenceUsingRecursion(text1, text2, i, j+1, n, m);
            
            return Math.max(skipText1, skipText2);
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequenceUsingRecursion(text1, text2, 0, 0, text1.length(), text2.length());
    }
}
*/





// solution using memoization

/*
class Solution {
    
    public int longestCommonSubsequenceUsingMemoization(String text1, String text2, int i, int j, int n, int m, int [][]memo){
        if(i == n || j == m){
            return 0;
        }
    
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        
        if(text1.charAt(i) == text2.charAt(j)){
            memo[i][j] = 1 + longestCommonSubsequenceUsingMemoization(text1, text2, i+1, j+1, n, m, memo);
        }
        else{
            int skipText1 = longestCommonSubsequenceUsingMemoization(text1, text2, i+1, j, n, m, memo);
            int skipText2 = longestCommonSubsequenceUsingMemoization(text1, text2, i, j+1, n, m, memo);
            
            memo[i][j] = Math.max(skipText1, skipText2);
        }
        
        return memo[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2){
        
        int[][] memo = new int[text1.length()][text2.length()];
        
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return longestCommonSubsequenceUsingMemoization(text1, text2, 0, 0, text1.length(), text2.length(), memo);
    }
}
*/






// using tabulation

class Solution {
    
    public int longestCommonSubsequenceUsingTabulation(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];

        // Initialize the base cases (dp array is already initialized with 0s)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequenceUsingTabulation(text1, text2);
    }

}