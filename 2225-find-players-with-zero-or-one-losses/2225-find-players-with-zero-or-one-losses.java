// class Solution {
//     public List<List<Integer>> findWinners(int[][] matches) {
//         Map<Integer, Integer> map1 = new HashMap<>();
//         Map<Integer, Integer> map2 = new HashMap<>();
        
//         for(int []arr : matches){
//             map1.put(arr[0], map1.getOrDefault(arr[0], 0)+1);
//             map2.put(arr[1], map2.getOrDefault(arr[1], 0)+1);
//         }
        
//         List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> noLost = new ArrayList<>();
//         List<Integer> oneLost = new ArrayList<>();
        
//         for(Map.Entry<Integer, Integer> entry  :  map1.entrySet()){
//             int key = entry.getKey();
//             if(map2.containsKey(key)){
//                 int val = map2.get(key);
//                 if(val == 1){
//                     oneLost.add(key);
//                 }
//                 else if(val == 0){
//                     noLost.add(key);
//                 }
//             }
            
//             if(!map2.containsKey(key)){
//                 noLost.add(key);
//             }
//         }
        
        
//         for(Map.Entry<Integer, Integer> entry  :  map2.entrySet()){
//             int val = entry.getValue();
//             int key = entry.getKey();
            
//             if(val == 1 && !oneLost.contains(key)){
//                 oneLost.add(key);
//             }
//         }
        
//         Collections.sort(noLost);
//         Collections.sort(oneLost);
        
//         ans.add(noLost);
//         ans.add(oneLost);
        
//         return ans;
//     }
// }



class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Set<Integer> oneLost = new HashSet<>();

        for (int[] arr : matches) {
            map1.put(arr[0], map1.getOrDefault(arr[0], 0) + 1);
            map2.put(arr[1], map2.getOrDefault(arr[1], 0) + 1);
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> noLost = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int key = entry.getKey();
            int val1 = entry.getValue();
            int val2 = map2.getOrDefault(key, 0);

            if (val2 == 1) {
                oneLost.add(key);
            } else if (val2 == 0) {
                noLost.add(key);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();

            if (val == 1 && !oneLost.contains(key)) {
                oneLost.add(key);
            }
        }
        
        Collections.sort(noLost);
        ans.add(noLost);
        List<Integer> oneLostSorted = new ArrayList<>(oneLost);
        Collections.sort(oneLostSorted);
        ans.add(oneLostSorted);

        return ans;
    }
}
