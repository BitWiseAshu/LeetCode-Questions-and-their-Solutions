class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        subsetsWithDupHelper(ans, nums, new ArrayList<>(), 0);
        return ans;
    }

    public void subsetsWithDupHelper(List<List<Integer>> ans, int[] nums, ArrayList<Integer> list, int n){

        if(n == nums.length){
            Collections.sort(list);
            if(!ans.contains(new ArrayList<>(list))){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        list.add(nums[n]);
        subsetsWithDupHelper(ans, nums, list, n+1);
        list.remove(list.size()-1);

        subsetsWithDupHelper(ans, nums, list, n+1);
    }
}