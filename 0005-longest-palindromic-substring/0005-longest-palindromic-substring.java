// class Solution {
//     public String longestPalindrome(String s) {
//         if (s == null || "".equals(s)) {
//             return s;
//         }
//         int c = 0;
//         for(int i = 0 ;i < s.length()-1 ;i++){
//             if(s.charAt(i) != s.charAt(i+1)){
//                 c++;
//             }
//         }

//         if(c == 0){
//             return s;
//         }

//         int n = s.length();
//         boolean dp[][] =new boolean[n][n];
//         String ans = "";
//         for(int g = 0 ; g < n ;g++){
//             for(int i = 0, j = g; j < n ; j++, i++){
//                 if(g == 0){
//                     dp[i][j] = true;
//                 }
//                 else if(g == 1){
//                     if(s.charAt(i) == s.charAt(j)){
//                         dp[i][j] = true;
//                     }else{
//                         dp[i][j] = false;
//                     }
//                 }
//                 else{
//                     if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
//                         dp[i][j] = true;
//                     }else{
//                         dp[i][j] = false;
//                     }
//                 }

//                 if(dp[i][j]){
//                     ans = s.substring(i,j+1);
//                 }
//             }
//         }
//         return ans;
//     }
// }



class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 0){
            return "";
        }
        
        boolean [][]dp = new boolean[n][n];
        int start = 0;
        int maxLength = 1;
        
        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check for substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        
        // Check for lengths greater than 2
        for (int L = 3; L <= n; L++) {
            for (int i = 0; i < n - L + 1; i++) {
                int j = i + L - 1;

                // Check if the substring from i to j is a palindrome
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;

                    if (L > maxLength) {
                        start = i;
                        maxLength = L;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }
}