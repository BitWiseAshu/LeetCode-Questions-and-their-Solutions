class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 0;
        }
        
        if(n == 2){
            if(nums[0] > nums[1]){
                return 0;
            }
            else{
                return 1;
            }
        }
        
        for(int i = 1; i < n-1; i++){
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                return i;
            }
        }
        
        return nums[0] > nums[n-1] ? 0 : n-1;
    }
}