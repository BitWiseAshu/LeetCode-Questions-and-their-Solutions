class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        subsetsHelper(nums, ans, currList, 0);
        return ans;
    }
    
    public void subsetsHelper(int []nums, List<List<Integer>> ans, List<Integer> currList, int index){
        
        // First method to solve
        /*
        ans.add(new ArrayList<>(currList));

        for (int i = index; i < nums.length; i++) {
            currList.add(nums[i]);
            subsetsHelper(nums, ans, currList, i + 1);
            currList.remove(currList.size() - 1);
        }
        */
        
        
        // SECOND METHOD
        
        if(index == nums.length){
            ans.add(new ArrayList<>(currList));
            return;
        }
        
        currList.add(nums[index]);
        subsetsHelper(nums, ans, currList, index+1);
        currList.remove(currList.size()-1);
        
        subsetsHelper(nums, ans, currList, index+1);
        
    }
}