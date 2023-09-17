class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        Stack<Character> st = new Stack<>();

        for(int i = s.length()-1; i >= 0; i--){
            if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                st.push(s.charAt(i));
            }
        }

        System.out.println(st);

        String str = "";
        while(!st.isEmpty()){
            str += st.pop();
        }

        System.out.println(str);
        
        boolean ans = isPalindromeHelper(str);

        return ans;
    }

    public boolean isPalindromeHelper(String str){
        if(str == ""){
            return true;
        }

        int start = 0;
        int end = str.length()-1;

        while(start <= end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }

        return true;
    }
}