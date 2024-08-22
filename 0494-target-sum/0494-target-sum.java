class Solution {
    
    public int findTargetSumWaysHelper(int []nums, int target, int index, int n, int num){
        if(index == n){
            if(num == target) return 1;
            else return 0;
        }
        
        int add = findTargetSumWaysHelper(nums, target, index+1, n, num + nums[index]);
        int sub = findTargetSumWaysHelper(nums, target, index+1, n, num - nums[index]);
        
        return add + sub;
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWaysHelper(nums, target, 0, nums.length, 0);
    }
}