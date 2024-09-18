class Solution {
    
    public boolean isSmallestDivisor(int []nums, int threshold, int n, int mid){
        
        int sum = 0;
        
        for(int i = 0; i < n; i++){
            sum += (int)(Math.ceil((double)nums[i] / mid));
        }
        
        // System.out.println(sum + " "+ mid);
        
        if(sum <= threshold) return true;
        return false;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        
        Arrays.sort(nums);
        
        int low = 1;
        int high = nums[n-1];
        
        int ans = -1;
        
        while(low <= high){
            int mid = (low + high)/2;
            
            if(isSmallestDivisor(nums, threshold, n, mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        
        return ans;
    }
}