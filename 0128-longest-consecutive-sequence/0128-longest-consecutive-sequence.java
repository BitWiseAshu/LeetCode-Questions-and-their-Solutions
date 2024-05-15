class Solution {
    /*
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int count = 1;
        int max = 1;
        
        for(int i = 0;  i < nums.length -1; i++){
            if(nums[i] == nums[i+1]){
                continue;
            }
            else{
                if(nums[i]+1 == nums[i+1]){
                    count ++;
                    if(count > max){
                        max = count;
                    }
                }
                else{
                    count = 1;   
                }
            }
        }
        
        return max;
    }
    */
    
    
    
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        
        if(n == 0){
            return 0;
        }
        
        // sort the nums arr
        Arrays.sort(nums);
        int count  = 1;
        int max = 1;
        
        for (int i = 0; i < n-1; i++){
            if(nums[i] == nums[i+1]){
                continue;
            }
            else{
                if(nums[i+1] - nums[i] == 1){
                    count  = count+1;
                    
                    if(max < count){
                        max = count;
                    }
                    
                }
                else{
                    count = 1;
                }
            }
        }
        
        return max;
    }
}