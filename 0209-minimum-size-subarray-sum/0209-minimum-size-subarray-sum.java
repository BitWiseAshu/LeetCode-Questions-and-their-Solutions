class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        
        while(i < nums.length){
            sum += nums[i];
            
        
            
            if(sum >= target){
                int len = i - j + 1;
                minLen = Math.min(len, minLen);
                
                while(sum >= target && j < i){
                    sum -= nums[j];
                    j++;
                    
                    if(sum >= target){
                        len = i - j + 1;
                        minLen = Math.min(len, minLen);
                    }
                    
                }
            }
            i++;
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}