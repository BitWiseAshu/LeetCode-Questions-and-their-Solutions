class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0;
        int count = 0;
        int n = s.length();
        
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        
        for (int r = 0; r < n; r++) {
            if (s.charAt(r) == 'a') {
                aCount++;
            } else if (s.charAt(r) == 'b') {
                bCount++;
            } else if (s.charAt(r) == 'c') {
                cCount++;
            }
            
            while (aCount > 0 && bCount > 0 && cCount > 0) {
                count += (n - r);
                if (s.charAt(l) == 'a') {
                    aCount--;
                } else if (s.charAt(l) == 'b') {
                    bCount--;
                } else if (s.charAt(l) == 'c') {
                    cCount--;
                }
                l++;
            }
        }
        
        return count;
    }
}