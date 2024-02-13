class Solution {
    
    
    public boolean isPallindrome(String s){
        int i = 0;
        int j = s.length()-1;
        
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
    
    public String firstPalindrome(String[] words) {
        int n = words.length;
        
        for(int i = 0; i < n; i++){
            if(isPallindrome(words[i])){
                return words[i];
            }
        }
        
        return "";
    }
}