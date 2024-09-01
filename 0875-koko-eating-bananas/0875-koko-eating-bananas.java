class Solution {
    
    public boolean canEat(int piles[], int mid, int h, int n) {
        int time = 0;
        for (int i = 0; i < n; i++) {
            // Correct time calculation: ceil(piles[i] / mid) = (piles[i] + mid - 1) / mid
            time += (piles[i] + mid - 1) / mid;
            // If time already exceeds h, no need to continue
            if (time > h) {
                return false;
            }
        }
        return time <= h;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile); // Find the maximum pile size
        }
        
        int ans = high;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            boolean eat = canEat(piles, mid, h, n);
            if (eat) {
                ans = mid; // Update answer with current mid if Koko can finish in time
                high = mid - 1; // Try a smaller speed
            } else {
                low = mid + 1; // Try a larger speed
            }
        }
        
        return ans;
    }
}
