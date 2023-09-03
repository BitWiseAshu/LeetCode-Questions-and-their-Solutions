class Solution {
    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> positiveElem = new LinkedList<>();
        Queue<Integer> negativeElem = new LinkedList<>();
        int n = nums.length;
        
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] > 0){
                positiveElem.add(nums[i]);
            }
            else if(nums[i] < 0){
                negativeElem.add(nums[i]);
            }
        }
        
        for(int i = 0 ; i < n; i = i+2){
            nums[i] = positiveElem.remove();
        }
        
        for(int i = 1; i < n; i = i+2){
            nums[i] = negativeElem.remove();
        }
        
        return nums;
        
    }
}