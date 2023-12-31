class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character, Queue<Integer> > map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                // If the character is already in the map, update the existing queue
                map.get(ch).add(i);
            } 
            else {
                // If the character is not in the map, create a new queue and add the index
                Queue<Integer> value = new LinkedList<>();
                value.add(i);
                map.put(ch, value);
            }
        }
        
        int maxLength = -1;

        for (Map.Entry<Character, Queue<Integer>> entry : map.entrySet()) {
            Queue<Integer> indices = entry.getValue();

            if (indices.size() > 1) {
                // Calculate the distance between the first and last index for each character
                ArrayList<Integer> indexList = new ArrayList<>(indices);
                int distance = indexList.get(indexList.size() - 1) - indexList.get(0) - 1;
                maxLength = Math.max(maxLength, distance);
            }
        }

        return maxLength;
        
    }
}