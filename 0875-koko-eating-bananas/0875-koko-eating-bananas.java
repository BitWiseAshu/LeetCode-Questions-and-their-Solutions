class Solution {
    
    public boolean canEat(int piles[], int mid, int h, int n) {
        int time = 0;
        for (int i = 0; i < n; i++) {
            time += (piles[i] + mid - 1) / mid;
            
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
            high = Math.max(high, pile);
        }
        
        int ans = high;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            boolean eat = canEat(piles, mid, h, n);
            if (eat) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
}
