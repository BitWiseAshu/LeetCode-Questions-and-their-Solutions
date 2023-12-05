class Solution {
    public int numberOfMatches(int n) {
        int ans = 0;
        return numberOfMatchesHelper(n, ans);

    }

    public int numberOfMatchesHelper(int n, int ans){
        if(n == 1){
            return ans;
        }

        if(n%2 != 0){
            return numberOfMatchesHelper(((n-1)/2)+1, ans + (n-1)/2);
        }
        
        return numberOfMatchesHelper(n/2, ans+n/2);
    }
}