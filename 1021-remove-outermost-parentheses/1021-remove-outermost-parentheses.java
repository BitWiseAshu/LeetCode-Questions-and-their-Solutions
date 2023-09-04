class Solution {
    public String removeOuterParentheses(String s) {
        String str = "";
        int count = 0;
        
        for(int i = 0 ; i < s.length(); i++){
            
            char ch = s.charAt(i);
            
            if(ch=='(' && count == 0){
                count ++;
            }
            else if(ch =='(' && count >=1){
                str +=ch;
                count ++;
            }
            
            if(ch == ')' && count > 1){
                str +=ch;
                count --;
            }
            else if(ch ==')' && count ==1){
                count --;
            }
        }
        return str;
    }
}