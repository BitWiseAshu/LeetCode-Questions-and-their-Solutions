class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    
    private int atMostK(int[] nums, int k) {
        int left = 0, right = 0, result = 0;
        int n = nums.length;
        
        while (right < n) {
            if (nums[right] % 2 == 1) {
                k--;
            }
            right++;
            
            while (k < 0) {
                if (nums[left] % 2 == 1) {
                    k++;
                }
                left++;
            }
            
            result += right - left;
        }
        
        return result;
    }
    
}
