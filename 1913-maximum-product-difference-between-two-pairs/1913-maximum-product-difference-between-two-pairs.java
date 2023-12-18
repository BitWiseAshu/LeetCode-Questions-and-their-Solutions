class Solution {
    public int maxProductDifference(int[] nums) {
        int firstMax = 0;
        int secondMax = 0;
        
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > firstMax){
                secondMax = firstMax;
                firstMax = nums[i];
            }
            else if(nums[i] > secondMax){
                secondMax = nums[i];
            }
            
            if(nums[i] < firstMin){
                secondMin = firstMin;
                firstMin = nums[i];
            }
            else if(nums[i] < secondMin){
                secondMin = nums[i];
            }
        }
        
        return ((firstMax*secondMax) - (firstMin*secondMin));
        
    }
}