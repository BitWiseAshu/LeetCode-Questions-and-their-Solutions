class Solution {
    public String reverseWords(String s) {
        s = s.trim(); // Remove leading and trailing spaces
        StringBuilder newStr = new StringBuilder();
        StringBuilder newStrHelper = new StringBuilder();
    
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                newStrHelper.reverse(); // Reverse the word
                newStr.append(newStrHelper).append(" "); // Append the reversed word and a space
                newStrHelper.setLength(0); // Clear the newStrHelper
            } else {
                newStrHelper.append(s.charAt(i)); // Build the word
            }
        }
    
        newStrHelper.reverse(); // Reverse the last word (no trailing space)
        newStr.append(newStrHelper); // Append the last word
    
        return newStr.toString();
    }
}