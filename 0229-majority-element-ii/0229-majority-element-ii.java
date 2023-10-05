class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ans  = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int k = n/3;
        
        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > k){
                ans.add(entry.getKey());
            }
        }
        // System.out.println(map);
        return ans;
    }
}