// Recursion

/*

class Solution {
    
    public boolean compare(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        
        // The length difference must be exactly 1 to form a valid chain
        if(Math.abs(n - m) != 1) {
            return false;
        }
        
        // Ensure s1 is the longer string
        if(n < m) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        
        int i = 0, j = 0;
        boolean differenceFound = false;
        
        // Iterate through both strings and compare character by character
        while(i < s1.length() && j < s2.length()) {
            if(s1.charAt(i) != s2.charAt(j)) {
                if(differenceFound) {
                    return false;
                }
                differenceFound = true;
                i++; // Skip one character in the longer string
            } else {
                i++;
                j++;
            }
        }
        
        return true;
    }
    
    public int longestStrChainHelper(String []words, int index, int n, String prev){
        if(index == n){
            return 0;
        }
        
        int take = 0;
        if(prev.equals("") || compare(words[index], prev)){
            take = 1 + longestStrChainHelper(words, index+1, n, words[index]);
        }
        
        int notTake = longestStrChainHelper(words, index+1, n, prev);
        
        return Math.max(take, notTake);
    }
    
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length()); // Sort by word length
        return longestStrChainHelper(words, 0, words.length, "");
    }
}
*/








class Solution {
    
    public boolean compare(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        
        // The length difference must be exactly 1 to form a valid chain
        if(Math.abs(n - m) != 1) {
            return false;
        }
        
        // Ensure s1 is the longer string
        if(n < m) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        
        int i = 0, j = 0;
        boolean differenceFound = false;
        
        // Iterate through both strings and compare character by character
        while(i < s1.length() && j < s2.length()) {
            if(s1.charAt(i) != s2.charAt(j)) {
                if(differenceFound) {
                    return false;
                }
                differenceFound = true;
                i++; // Skip one character in the longer string
            } else {
                i++;
                j++;
            }
        }
        
        return true;
    }
    
    public int longestStrChain(String[] words) {
        int n = words.length;
        
        // Sort the words by their lengths
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        // Create a DP array where dp[i] stores the longest chain ending at words[i]
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Initialize all dp values to 1 since each word is a chain of length 1
        
        int maxChainLength = 1; // Store the maximum chain length
        
        // Build the DP array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (compare(words[i], words[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // Update the overall maximum chain length
            maxChainLength = Math.max(maxChainLength, dp[i]);
        }
        
        return maxChainLength;
    }
}
