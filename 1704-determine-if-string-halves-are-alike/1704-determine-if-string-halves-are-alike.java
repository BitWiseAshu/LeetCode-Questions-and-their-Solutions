class Solution {
    public boolean halvesAreAlike(String s) {
        HashSet<Character> set = new HashSet<>();
        
        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');
        set.add('A'); set.add('E'); set.add('I'); set.add('O'); set.add('U');
        
        int n = s.length()/2;
        
        int a = 0;
        int b = 0;
        
        for(int i = 0 ; i < n; i++){
            if(set.contains(s.charAt(i))) a++;
            if(set.contains(s.charAt(i+n))) b++;
        }
        
        return a == b;
    }
}