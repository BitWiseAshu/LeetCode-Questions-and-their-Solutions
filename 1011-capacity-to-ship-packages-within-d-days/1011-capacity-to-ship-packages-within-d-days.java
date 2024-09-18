class Solution {
    public boolean isPossibleToshipWithinDays(int []weights, int days, int n, int mid){
        
        int sum = 0;
        
        int d = 1;
            
        for(int i = 0;i < n; i++){
            if(sum + weights[i] > mid){
                sum = weights[i];
                d++;
            }
            else{
                sum += weights[i];
            }
        }
        
        return d <= days;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        
        int low = 0;
        int high = 0;
        
        for(int i = 0; i < n; i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }
        
        int ans = -1;
        
        while(low <= high){
            int mid = (low + high)/2;
            
            if(isPossibleToshipWithinDays(weights, days, n, mid)){
                high = mid-1;
                ans = mid;
            }
            else{
                low = mid+1;
            }
        }
        
        return ans;
    }
}