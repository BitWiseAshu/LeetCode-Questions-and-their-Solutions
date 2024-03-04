class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int length = 0;
        
        while(right < s.length()){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            
            map.put(s.charAt(right), right);
            
            length = Math.max(length, right-left+1);
            right ++;
        }
        
        return length;
    }
}