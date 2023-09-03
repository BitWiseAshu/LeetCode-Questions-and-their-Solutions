class Solution {
    public int majorityElement(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
        Arrays.sort(nums);
        int k = n/2;
        int count  = 1;
        
        for(int i = 0 ; i < n-1 ;i++){
            if(nums[i] == nums[i+1]){
                count ++;
            }else{
                count = 1;
            }
            
            if(count > k){
                return nums[i];
                
            }
        }
        
        return -1;
    }
}