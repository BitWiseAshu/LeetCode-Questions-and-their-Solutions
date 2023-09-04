class Solution {
    public String frequencySort(String s) {
        TreeMap<Character, Integer> frequencyMap = new TreeMap<Character, Integer>();
        
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(frequencyMap.containsKey(ch)){
                int currentValue = frequencyMap.get(ch);
                
                // Increase the value by 1
                int updatedValue = currentValue + 1;
    
                // Put the updated value back into the TreeMap
                frequencyMap.put(ch, updatedValue);
            }else{
                frequencyMap.put(ch, 1);
            }
            
            /*
                // this is simplest way to store key and increease value of Duplicate Key
                // frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            */
        }
        
        // Create a list of entries (character, frequency) sorted by frequency (in descending  order)
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        
        /*
        // checking how the data is store in entryList
        
        for(int i = 0 ; i < entryList.size(); i++){
            System.out.println(entryList.get(i));
        }
        */ 
        
        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        
        String str = "";
        
        for (Map.Entry<Character, Integer> entry : entryList) {
            char character = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; i++) {
                str += character;
            }
        }
        
        return str;
        
    }
}