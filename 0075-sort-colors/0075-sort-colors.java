class Solution {
    public void sortColors(int[] nums) {
        int[] counts = new int[3]; // To count the occurrences of 0, 1, and 2
    
        // Count the occurrences of each color
        for (int num : nums) {
            counts[num]++;
        }
        
        int index = 0;
        
        // Fill the array with the sorted colors
        for (int color = 0; color < 3; color++) {
            while (counts[color] > 0) {
                nums[index] = color;
                index++;
                counts[color]--;
            }
        }
    }
}