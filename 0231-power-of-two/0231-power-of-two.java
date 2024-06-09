class Solution {
    /*
    public boolean isPowerOfTwo(int n) {
        if(n == 1){
            return true;
        }

        if(n%2 != 0 || n == 0){
            return false;
        }

        n = n/2;
        boolean ans = isPowerOfTwo(n);
        return ans;
    }
    */
    
    
    public boolean isPowerOfTwo(int n) {
        
            return n > 0&& ((n & (n-1)) == 0) ? true : false;
        
        
    }
}