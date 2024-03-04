class Solution {
    
    public int longestOnes(int[] nums, int k) {
        int j = 0;
        int count0 = 0;
        int length = 0;
        
        for(int i = 0 ;  i < nums.length; i++){
            if(nums[i] == 0){
                count0++;
            }
            
            while(count0 > k){
                if(nums[j] == 0){
                    count0 --;
                }
                j++;
            }
            
            length = Math.max(length, i-j+1);
        }
        return length;
    }
    
    /*
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
    */
}