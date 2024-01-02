class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        while(!map.isEmpty()){
            List<Integer> l = new ArrayList<>();
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                int key = entry.getKey();
                l.add(key);
                entry.setValue(entry.getValue() - 1);

                if (entry.getValue() == 0) {
                    iterator.remove();
                }
            }
            
            list.add(l);
        }
        
        return list;
    }
}