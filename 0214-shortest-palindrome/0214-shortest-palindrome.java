// Gives time limit exceed
/*
class Solution {
    public String shortestPalindromeHelper(String s) {
        
        int n = s.length();
        int i = 0;
        int j = n-1;
        
        String str  = "";
        
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else{
                str += s.charAt(j);
                j--;
            }
        }
        
        str = str + s;
        
        return str;
    }
    
    public boolean isPallindrome(String s){
        int i = 0;
        int j = s.length()-1;
        
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
    
    public String shortestPalindrome(String s) {
        String str = shortestPalindromeHelper(s);
        
        while(!isPallindrome(str)){
            str = shortestPalindromeHelper(str);
        }
        
        return str;
    }
}
*/





class Solution {

    public String shortestPalindrome(String s) {
        int n = s.length();
        int i = 0;

        // Find the longest prefix which is a palindrome
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
        }

        // If the entire string is a palindrome
        if (i == n) {
            return s;
        }

        // The suffix that is not part of the palindrome
        String suffix = s.substring(i);
        System.out.println(suffix);
        
        // Reverse the suffix and prepend it to the original string
        String prefix = new StringBuilder(suffix).reverse().toString();
        
        System.out.println(prefix);
        // Recursively find the shortest palindrome
        return prefix + shortestPalindrome(s.substring(0, i)) + suffix;
    }
}