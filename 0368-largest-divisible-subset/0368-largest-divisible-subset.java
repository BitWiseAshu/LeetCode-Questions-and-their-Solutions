class Solution {
    
    public List<Integer> largestDivisibleSubset(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int[] hash = new int[n];
        Arrays.fill(hash, 1);
        
        for (int i = 0; i <= n - 1; i++) {
            hash[i] = i; // initializing with current index
            for (int prev_index = 0; prev_index <= i - 1; prev_index++) {
                if (arr[i] % arr[prev_index] == 0 && dp[i] < dp[prev_index] + 1) {
                    dp[i] = 1 + dp[prev_index];
                    hash[i] = prev_index;
                }
            }
        }
        
        int ans = -1;
        int lastIndex = -1;
        
        for (int i = 0; i <= n - 1; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                lastIndex = i;
            }
        }
        
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[lastIndex]);
        
        while (hash[lastIndex] != lastIndex) { // till not reach the initialization value
            lastIndex = hash[lastIndex];
            temp.add(arr[lastIndex]);
        }
        
        // Reverse the list to get the LIS in the correct order
        Collections.reverse(temp);
        
        return temp;
    }
}