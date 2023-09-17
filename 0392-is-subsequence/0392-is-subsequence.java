class Solution {
    public boolean isSubsequence(String s, String t) {
        
        /*
        int sLen = s.length();
        int tLen = t.length();
        
        if(sLen < 1){
            return true;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < tLen ; i++){
            map.put(t.charAt(i), i);
        }
        
        char ch[] = s.toCharArray();
        
        int prevIdx = -1;
        
        for(int i = 0; i < ch.length; i++){
            if(!map.containsKey(ch[i])){
                return false;
            }
            else{
                int chIndex = map.get(ch[i]);
                
                if(chIndex <= prevIdx){
                    return false;
                }
                
                prevIdx = chIndex;
            }
        }
        
        return true;
        */


        int sIndex = 0; 
        int tIndex = 0; 

        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }

        return sIndex == s.length();
    }
    
}