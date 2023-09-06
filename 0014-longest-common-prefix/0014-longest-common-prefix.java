class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        String firstStr = strs[0];
        String ans = "";
        
        for(int i = 0 ; i < m; i++){
            char ch = firstStr.charAt(i);
            for(int j = 1; j < n; j++){
                String s = strs[j];
                int sLen = s.length()-1;
                if(sLen < i){
                    return ans;
                }
                char ch1 = s.charAt(i);
                if(ch != ch1){
                    return ans;
                }
            }
            ans += ch;
        }
        return ans;
    }
}