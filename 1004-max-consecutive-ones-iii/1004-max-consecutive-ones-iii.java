class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0; 
        int j = 0;
        int count = 0;
        
        int ans = 0;
        
        while(i < nums.length){
            if(nums[i] == 0){
                count ++;
            }
            i++;
            
            // if(count > k){
            //     count --;
            //     j++;
            // }
            
            while(count > k){
                
                if(nums[j] == 0){
                    count --;
                }
                j++;
            }
            
            ans =Math.max(ans, i-j);
            
        }
        
        return ans;
    }
}