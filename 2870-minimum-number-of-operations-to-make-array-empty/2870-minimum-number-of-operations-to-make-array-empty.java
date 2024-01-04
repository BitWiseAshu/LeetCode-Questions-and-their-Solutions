class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int ans = 0;
        
//         System.out.println(map);
//         for (int key : map.keySet()) {
//             int count = map.get(key);
//             System.out.println(count);
            
//             int two = count % 2;
//             int three = count % 3;
            
//             if(two == 0){
//                 ans = ans + (count/2);
//                 continue;
//             }
//             else if(two != 0 && three != 0){
//                 if(two == 1 && count % 3 != 0){
//                     return -1;
//                 }
//                 else if(two % 3 == 0){
//                     ans = ans + (count/2)+ (two/3);
//                     continue;
//                 }
//                 else {
//                     return -1;
//                 }
//             }
            
//             if(three == 0){
//                 ans = ans + (count/3);
//                 continue;
//             }
//             else if(three != 0 && two != 0){
//                 if(three == 1 && count % 2 != 0){
//                     return -1;
//                 }
//                 else if(three % 2 == 0){
//                     ans = ans + (count/3) + (three/2);
//                     continue;
//                 }
//                 else {
//                     return -1;
//                 }
//             }
            
//         }
//         return ans;
        
        
        for (int key : map.keySet()) {
            int count = map.get(key);
            // System.out.println(count);
            
            if(count == 1){
                return -1;
            }
            
            ans += count / 3;
            if (count % 3 != 0) {
                ans++;
            }
        }
        
        return ans;
    }
}