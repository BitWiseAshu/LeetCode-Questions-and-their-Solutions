class Solution {
    // first method using Recursion
    /*
    public int numDecodingsHelper(String s, int index){
        if(s.length() == index){
            return 1;
        }
        
        if(s.charAt(index) == '0'){
            return 0;
        }
        
        int ways = numDecodingsHelper(s, index+1);
        
        if(index+1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26){
            ways += numDecodingsHelper(s, index+2);
        }
        
        return ways;
        
    }
    
    public int numDecodings(String s) {
        return numDecodingsHelper(s, 0);
    }
    */
    
    
    
    public int numDecodingsHelper(String s, int index, int []memo){
        if(s.length() == index){
            return 1;
        }
        
        if(s.charAt(index) == '0'){
            return 0;
        }
        
        if(memo[index] != -1){
            return memo[index];
        }
        
        int ways = numDecodingsHelper(s, index+1, memo);
        
        if(index+1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26){
            ways += numDecodingsHelper(s, index+2, memo);
        }
        
        memo[index] = ways;
        
        return ways;
        
    }
    
    public int numDecodings(String s) {
        int memo[] = new int[s.length()];
        Arrays.fill(memo, -1);
        return numDecodingsHelper(s, 0, memo);
    }
}