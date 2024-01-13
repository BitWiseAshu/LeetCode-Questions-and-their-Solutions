class Solution {
    public int minSteps(String s, String t) {
        TreeMap<Character, Integer> map1 = new TreeMap<>();
        TreeMap<Character, Integer> map2 = new TreeMap<>();
        
        for(int i = 0; i < s.length(); i++){
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0)+1);
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0)+1);
        }
        
        int ans = 0;
        
        for(Map.Entry<Character, Integer> entry : map2.entrySet()){
            char ch = entry.getKey();
            int val = entry.getValue();
            
            if(map1.containsKey(ch)){
                int map1Val = map1.get(ch);
                if(map1Val < val){
                    ans = ans + (val-map1Val);
                }
            }
            else if(!map1.containsKey(ch)){
                ans = ans + val;
            }
            
        }
        
        return ans;
    }
}