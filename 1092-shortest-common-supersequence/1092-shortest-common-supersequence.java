// Recursion
/*
class Solution {
    
    public String shortestCommonSupersequenceUsingRecursion(String str1, String str2, int i, int j, int n, int m){
        
        if(i == n){
            return str2.substring(j);
        }
        
        if(j == m){
            return str1.substring(i);
        }
        
        if(str1.charAt(i) == str2.charAt(j)){
            return str1.charAt(i) + shortestCommonSupersequenceUsingRecursion(str1, str2, i+1, j+1, n, m);
        }
        else{
            String takeStr1 = str1.charAt(i) + shortestCommonSupersequenceUsingRecursion(str1, str2, i+1, j, n, m);
            String takeStr2 = str2.charAt(j) + shortestCommonSupersequenceUsingRecursion(str1, str2, i, j+1, n, m);
            
            return (takeStr1.length() < takeStr2.length() ? takeStr1 : takeStr2);
        }
        
    }
    
    public String shortestCommonSupersequence(String str1, String str2) {
        return shortestCommonSupersequenceUsingRecursion(str1, str2, 0, 0, str1.length(), str2.length());
    }
}
*/










// Memoization 

/*
class Solution {
    
    public String shortestCommonSupersequenceUsingRecursion(String str1, String str2, int i, int j, int n, int m, String [][]dp){
        
        if(i == n){
            return str2.substring(j);
        }
        
        if(j == m){
            return str1.substring(i);
        }
        
        if(dp[i][j] != null){
            return dp[i][j];
        }
        
        if(str1.charAt(i) == str2.charAt(j)){
            dp[i][j] = str1.charAt(i) + shortestCommonSupersequenceUsingRecursion(str1, str2, i+1, j+1, n, m, dp);
        }
        else{
            String takeStr1 = str1.charAt(i) + shortestCommonSupersequenceUsingRecursion(str1, str2, i+1, j, n, m, dp);
            String takeStr2 = str2.charAt(j) + shortestCommonSupersequenceUsingRecursion(str1, str2, i, j+1, n, m, dp);
            
            dp[i][j] = (takeStr1.length() < takeStr2.length() ? takeStr1 : takeStr2);
        }
        
        return dp[i][j];
    }
    
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        String[][] dp = new String[m + 1][n + 1];
        
        return shortestCommonSupersequenceUsingRecursion(str1, str2, 0, 0, str1.length(), str2.length(), dp);
    }
}
*/





// tabulation

class Solution {
    
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        
        // Initialize dp table
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i; // Fill first column
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j; // Fill first row
        }
        
        // Fill the dp array using tabulation
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Reconstruct the shortest common supersequence using dp array
        int i = n, j = m;
        StringBuilder sb = new StringBuilder();
        
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }
        
        // Add remaining characters of str1 or str2
        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }
        
        // Return the reverse of the built string
        return sb.reverse().toString();
    }
}
