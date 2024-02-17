class Solution {
    
    public int findFirst(int[] arr, int n, int x) {
        int start = 0;
        int end = n - 1;

        int floor = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midElement = arr[mid];

            if (midElement == x) {
                floor = mid;
                end = mid - 1; // Look for the first occurrence in the left half
            } else if (midElement > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return floor;
    }

    public int findLast(int[] arr, int n, int x) {
        int start = 0;
        int end = n - 1;

        int ceil = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midElement = arr[mid];

            if (midElement == x) {
                ceil = mid;
                start = mid + 1; // Look for the last occurrence in the right half
            } else if (midElement > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ceil;
    }

    public int[] searchRange(int[] nums, int target) {
        int firstIndex = findFirst(nums, nums.length, target);
        int lastIndex = findLast(nums, nums.length, target);

        return new int[]{firstIndex, lastIndex};
    }
}
