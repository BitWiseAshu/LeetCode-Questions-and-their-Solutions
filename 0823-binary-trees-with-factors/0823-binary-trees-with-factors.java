class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        
        Arrays.sort(arr);
    
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Long> map = new HashMap<>();
        
        for(int i = 0;i < n ; i++){
            list.add(arr[i]);
            map.put(arr[i],1L);
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i]%arr[j] == 0){
                    int remain = arr[i]/arr[j];
                    
                    if(list.contains(remain)){
                        // long remainChild = map.get(remain);
                        // if(remainChild > 1){
                        //     remainChild = remainChild-1;
                        //     // remainChild *= 2;
                        // }else if(remainChild == 1){
                        //     remainChild = 0;
                        // }

                        // map.put(arr[i], map.getOrDefault(arr[i], 0L) + 1+remainChild);
                        // map.put(arr[i], (map.get(map.get(arr[j])* map.get(arr[i]/arr[j])) % 1000000007);
                        map.put(arr[i], (map.get(arr[i]) + map.get(arr[j]) * map.get(remain)) % 1_000_000_007);
                        
                    }
                }
            }
        }
        
        long totalTrees = 0L;
        
        for (int key : map.keySet()) {
            totalTrees = (totalTrees + map.get(key)) % 1000000007;
        }

        return (int) totalTrees;  
    }
}