class Solution {
    public int searchInsert(int[] nums, int target) {
        int searchElement = search(nums, target);
        return searchElement;
    }
    
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int index = -1;

        while(start <= end){
            int mid = (start+end)/2;

            if(nums[mid] == target){
                return mid;
            }
            
            if(nums[mid] > target){
                end = mid-1;
            }
            else{
                start = mid+1;
                index = mid+1;
            }
        }

        return index == -1 ? 0 : index;
    }
}