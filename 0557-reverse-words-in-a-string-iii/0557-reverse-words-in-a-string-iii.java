class Solution {
    public String reverseWords(String s) {
        s = s.trim();

        Stack<Character> st = new Stack <>();
        String newStr = "";
        
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                while(!st.isEmpty()){
                    newStr += st.pop();
                }
                newStr += " ";
            }
            else{
                st.add(s.charAt(i));
            }
        }

        while(!st.isEmpty()){
            newStr += st.pop();
        }

        newStr.trim();
        return newStr;
    }
}