class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length; i++){
            int ans = nums[i];
            if(ans > max){
                max = ans;
            }
            
            for(int j = i+1; j < nums.length; j++){
                ans *= nums[j];

                if(ans > max){
                    max = ans;
                }
            }
            
        }
        return max;
    }
}