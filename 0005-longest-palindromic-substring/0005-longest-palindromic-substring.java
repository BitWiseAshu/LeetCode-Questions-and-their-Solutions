class Solution {
    public String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        int c = 0;
        for(int i = 0 ;i < s.length()-1 ;i++){
            if(s.charAt(i) != s.charAt(i+1)){
                c++;
            }
        }

        if(c == 0){
            return s;
        }

        int n = s.length();
        boolean dp[][] =new boolean[n][n];
        String ans = "";
        for(int g = 0 ; g < n ;g++){
            for(int i = 0, j = g; j < n ; j++, i++){
                if(g == 0){
                    dp[i][j] = true;
                }
                else if(g == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }
                else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }

                if(dp[i][j]){
                    ans = s.substring(i,j+1);
                }
            }
        }
        return ans;
    }
}