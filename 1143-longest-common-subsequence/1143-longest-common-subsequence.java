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



class Solution {
    
    public int longestCommonSubsequenceUsingRecursion(String text1, String text2, int i, int j, int n, int m, int [][]memo){
        if(i == n || j == m){
            return 0;
        }
    
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        
        if(text1.charAt(i) == text2.charAt(j)){
            memo[i][j] = 1 + longestCommonSubsequenceUsingRecursion(text1, text2, i+1, j+1, n, m, memo);
        }
        else{
            int skipText1 = longestCommonSubsequenceUsingRecursion(text1, text2, i+1, j, n, m, memo);
            int skipText2 = longestCommonSubsequenceUsingRecursion(text1, text2, i, j+1, n, m, memo);
            
            memo[i][j] = Math.max(skipText1, skipText2);
        }
        
        return memo[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2){
        
        int[][] memo = new int[text1.length()][text2.length()];
        
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return longestCommonSubsequenceUsingRecursion(text1, text2, 0, 0, text1.length(), text2.length(), memo);
    }
}