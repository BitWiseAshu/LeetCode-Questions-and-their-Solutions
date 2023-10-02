//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int distinctSubsequences(String s) {
        // code here
        
        int n = s.length();
        int mod = 1000000007;
        
        int dp[] = new int[n+1];
        dp[0] = 1;
        
        Map<Character, Integer> lastSeen = new HashMap<>();
        
        for(int i = 1; i < dp.length; i++){
            dp[i] = (2 * dp[i - 1]) % mod;
            
            char ch = s.charAt(i-1);
            if(lastSeen.containsKey(ch)){
                int j = lastSeen.get(ch);
                dp[i] = (dp[i] - dp[j - 1] + mod) % mod;
            }
            
            lastSeen.put(ch, i);
            
        } 
        
        
        int ans = (dp[n] + mod) % mod;
        
        return ans;
        
    
    }
}