class Solution {
    
    // This is also a Right Solutionn but it gives time limit Exceed
    
    /*
    public int constrainedSubsetSum(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        
        int ans = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = Math.max(i - k, 0); j < i; j++) { // choose the max element in latest k elements, it's in range [i-k, i-1]
                max = Math.max(max, dp[j]);
            }
            dp[i] = arr[i] + max;
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
    
    */
    
    
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        int res = nums[0];
        
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            
            
            if(!deque.isEmpty()){
                dp[i] += dp[deque.peekFirst()];
            }
            
            res = Math.max(res, dp[i]);
            
            if(!deque.isEmpty() && i - deque.peekFirst() >= k){
                deque.pollFirst();
            }
            
            while(!deque.isEmpty() && dp[i] > dp[deque.peekLast()]){
                deque.pollLast();
            }
            
            if(dp[i] > 0){
                deque.offerLast(i);
            }
            
        }
    
        return res;
    }

}