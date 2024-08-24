// Using Tabulation method

/*
class Solution {
    public int minInsertions(String s) {
        String str = new StringBuilder(s).reverse(). toString();
        
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        
        for(int i = 0 ; i <= n; i++){
            dp[i][0] = 0;
        }
        
        for(int j = 0 ; j <= n; j++){
            dp[0][j] = 0;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i-1) == str.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return (n - dp[n][n]);
    }
}
*/








// Using Recursion 
/*
class Solution {
    public int minInsertions(String s) {
        String str = new StringBuilder(s).reverse().toString();
        
        return (s.length() - minInsertionsHelper(s, str, s.length(), 0, 0));
    }
    
    public int minInsertionsHelper(String s, String str, int n, int i, int j){
        if(i == n || j == n){
            return 0;
        }
        
        if(s.charAt(i) == str.charAt(j)){
            return 1 + minInsertionsHelper(s, str, n, i+1, j+1);
        }
        else{
            return Math.max(minInsertionsHelper(s, str, n, i+1, j), minInsertionsHelper(s, str, n, i, j+1));
        }
    }
}

*/


// Using memoization



class Solution {
    public int minInsertions(String s) {
        String str = new StringBuilder(s).reverse().toString();
        
        int n = s.length();
        
        int dp[][] = new int[n+1][n+1];
        for(int []arr : dp){
            Arrays.fill(arr, -1);
        }
        
        return (n - minInsertionsHelper(s, str, s.length(), 0, 0, dp));
    }
    
    public int minInsertionsHelper(String s, String str, int n, int i, int j, int dp[][]){
        if(i == n || j == n){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(s.charAt(i) == str.charAt(j)){
            dp[i][j] = 1 + minInsertionsHelper(s, str, n, i+1, j+1, dp);
        }
        else{
            dp[i][j] = Math.max(minInsertionsHelper(s, str, n, i+1, j, dp), minInsertionsHelper(s, str, n, i, j+1, dp));
        }
        
        return dp[i][j];
    }
}