class Solution {
    
    public int countZeros(String left){
        int count = 0;
        for(int i = 0; i < left.length(); i++){
            if(left.charAt(i) == '0'){
                count ++;
            }
        }
        
        return count;
    }
    
    public int countOnes(String right){
        int count = 0;
        for(int i = 0; i < right.length(); i++){
            if(right.charAt(i) == '1'){
                count ++;
            }
        }
        
        return count;
    }
    
    public int maxScore(String s) {
        int n = s.length();
        int max_score = Integer.MIN_VALUE;
        
        for(int i = 1; i < n; i++){
            String left = s.substring(0,i);
            String right = s.substring(i,n);
            
            int zeros = countZeros(left);
            int ones = countOnes(right);
            
            int sum = zeros + ones;
            if(sum > max_score){
                max_score = sum;
            }
        }
        
        return max_score;
    }
}