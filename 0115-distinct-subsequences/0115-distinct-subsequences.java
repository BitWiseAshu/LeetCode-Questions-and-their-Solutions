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
