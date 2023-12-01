class Solution {
    public List<String> generateParenthesis(int n) {
        int openParenthesis = 0;
        int closeParenthesis = 0;
        List<String> list = new ArrayList<>();
        generateParenthesisHelper(n, openParenthesis, closeParenthesis, list, "");
        return list;
    }
    
    public void generateParenthesisHelper(int n, int openParenthesis, int closeParenthesis, List<String> list, String s){
        if(openParenthesis == n && closeParenthesis == n){
            list.add(s);
            return;
        }
        
        if(openParenthesis < n){
            generateParenthesisHelper(n, openParenthesis+1, closeParenthesis,list, s+"(");
        }
        
        if(closeParenthesis < openParenthesis){
            generateParenthesisHelper(n, openParenthesis, closeParenthesis+1, list, s+")");
        }
    }
}