class Solution {

    /*
    int minFlipsStartWithZero = 0;
    int minFlipsStartWithOne = 0;
    public int minFlips(String s) {
        
        // Generate the desired alternating patterns based on the length of the input string
        StringBuilder patternStartingWithZeroBuilder = new StringBuilder();
        StringBuilder patternStartingWithOneBuilder = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            patternStartingWithZeroBuilder.append(i % 2 == 0 ? '0' : '1');
            patternStartingWithOneBuilder.append(i % 2 == 0 ? '1' : '0');
        }
        
        String patternStartingWithZero = patternStartingWithZeroBuilder.toString();
        String patternStartingWithOne = patternStartingWithOneBuilder.toString();

        System.out.println(patternStartingWithZero);
        System.out.println(patternStartingWithOne);
        
        
        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            // Check if the current character doesn't match the desired character for both patterns
            if (s.charAt(i) != patternStartingWithZero.charAt(i)) {
                minFlipsStartWithZero++;
            }
            if (s.charAt(i) != patternStartingWithOne.charAt(i)) {
                minFlipsStartWithOne++;
            }
        }
        
        // Return the minimum of the two counts
        return Math.min(minFlipsStartWithZero, minFlipsStartWithOne);
    }

    */


    public int minFlips(String s) {
        int n = s.length();
        
        int mininumFlip = Integer.MAX_VALUE;
        
        int misMatchCount = 0;
        for(int i = 0; i < (2 * n); i++){
            int r = i % n;

            if((s.charAt(r) - '0') != (i % 2 == 0 ? 1 : 0)) {
                misMatchCount++;
            }

            if(i >= n && (s.charAt(r) - '0') != (r % 2 == 0 ? 1 : 0)){
                misMatchCount--;  
            } 
            
            if(i >= n - 1) {
                mininumFlip = Math.min(mininumFlip, Math.min(misMatchCount, n - misMatchCount));
            }
        }
        
        return mininumFlip;
    }
}