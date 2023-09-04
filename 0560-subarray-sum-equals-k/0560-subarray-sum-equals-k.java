class Solution {
    
    public int subarraySum(int[] nums, int k) {

        /*
        int n = nums.length;
        
        int sum = 0;
        int cnt = 0;
        int i = 0;
        int j = 0;
        
        while(i < n){
            sum += nums[i];
            
            if(sum == k){
                cnt ++;
                sum = 0;
                j++;
                i = j;
                continue;
            }
            else if(sum > k){
                sum = 0; 
                j++;
                i = j;
                continue;
            }

            i++;
        }
        
        return cnt;
        */
        
        
        
        /*
        int count = 0;
        for(int i =0; i<nums.length; i++){
            int sum =0;
            for(int j =i; j<nums.length; j++){
                sum += nums[j];
                if(sum==k){
                    count++;
                }
            }
            
        }
        return count;
        
        */
        
        int n = nums.length;
        
        int arr[] = new int[n];
        arr[0] = nums[0];
        
        for(int i = 1 ; i < n ; i++){
            arr[i] = nums[i] + arr[i-1];
        }
        
        int count = 0;
        
        for(int i= 0; i < n; i++){
            if(arr[i] == k){
                count ++;
            }
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(arr[i] - k))
                count += map.get(arr[i] - k);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        return count;
    }
    
}