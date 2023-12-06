class Solution {
    
    class Pair{
        String s;
        int steps;
        
        Pair(String s, int steps){
            this.s = s;
            this.steps = steps;
        }
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        
        Set<String> set = new HashSet<>();
        
        for(int i = 0 ; i < wordList.size(); i++){
            set.add(wordList.get(i));
        }
        
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }
        
        
        while(!q.isEmpty()){
            Pair front = q.poll();
            String word = front.s;
            int steps = front.steps;
            
            if(word.equals(endWord)){
                return steps;
            }
            
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char []charArray = word.toCharArray();
                    charArray[i] = ch;
                    String modifiedWord = new String(charArray);
                    
                    if(set.contains(modifiedWord)){
                        set.remove(modifiedWord);
                        q.add(new Pair(modifiedWord, steps + 1));
                    }
                }
            }
        }
        
        return 0;
        
    }
}