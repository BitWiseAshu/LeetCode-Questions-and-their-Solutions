class Solution {

    int solve(int[] num){
        int n = num.length;
        int[] dp = new int[n];
        
        if(n==0)
            return 0;

        dp[0] = num[0];
        
        if(n>1)
            dp[1] = Math.max(num[0],num[1]);
        
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-2]+num[i],dp[i-1]);
        }
        
        return dp[n-1];
    }

    public int rob(int[] nums) {
        
        int n = nums.length;
        if(n==1)
        return nums[0];
        
        int ans1 = solve(Arrays.copyOfRange(nums,0,n-1));
        int ans2 = solve(Arrays.copyOfRange(nums,1,n));
        return Math.max(ans1,ans2);

    }
}