public class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        HashMap<Character, Integer> mp = new HashMap<>();

        int ans = Integer.MAX_VALUE; // Length of the minimum window
        int start = 0; 

        // Populate the map with the characters of t and their frequencies
        for (char x : t.toCharArray())
            mp.put(x, mp.getOrDefault(x, 0) + 1);

        int count = mp.size(); // Number of unique characters in t that need to be present in the window

        int i = 0, j = 0; // Two pointers for the sliding window

        while (j < s.length()) {
            // Decrement the count of the current character in the map
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) - 1);
            if (mp.get(s.charAt(j)) == 0)
                count--; // When a character's count reaches 0, it means we have all instances of that character in the window

            // When all characters in t are present in the window
            if (count == 0) {
                // Try to minimize the window
                while (count == 0) {
                    // Update the minimum window size and start position
                    if (ans > j - i + 1) {
                        ans = j - i + 1;
                        start = i;
                    }

                    // Remove the character at i from the window
                    mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
                    if (mp.get(s.charAt(i)) > 0)
                        count++; // If a character count goes above 0, it means we no longer have all required instances in the window

                    i++; // Move the left pointer to the right
                }
            }
            j++; // Move the right pointer to the right
        }

        // If a valid window was found, return the substring
        if (ans != Integer.MAX_VALUE)
            return s.substring(start, start + ans);
        else
            return "";
    }
}
