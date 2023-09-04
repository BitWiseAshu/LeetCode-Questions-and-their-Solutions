class Solution {
    public String reverseWords(String s) {
        
        Stack<Character> st = new Stack<>();
        s = s.trim();
        String str = "";
        
        for(int i = s.length()-1; i >= 0; i--){
        
            char ch = s.charAt(i);
            
            if(ch == ' '){
                if(!st.isEmpty()){
                    while(!st.isEmpty()){
                        str += st.pop();
                    }
                    str += ch;
                }
                
            }
            else if(ch != ' '){
                st.push(ch);
            }
        }
        
        while(!st.isEmpty()){
            str += st.pop();
        }
        
        str = str.trim();
        return str;
    }
}