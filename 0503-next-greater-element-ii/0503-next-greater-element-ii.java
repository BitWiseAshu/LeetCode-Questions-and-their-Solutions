class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        
        int ans[] = new int[n];
        for(int i = 0; i < n; i++){
            int currElem = nums[i];
            int currIndex = i;
            
            int greaterElem = nextGreaterElementsHelper(nums, currIndex, currElem);
            
            ans[i] = greaterElem;
        }
        
        return ans;
    }
    
    public int nextGreaterElementsHelper(int []arr, int index, int currElem){
        int n = arr.length;
        
        for(int i = index+1; i < index + n; i++){
            
            int currIndex = i%n;
            
            if(arr[currIndex] > currElem){
                return arr[currIndex];
            }
        }
        
        return -1;
    }
}