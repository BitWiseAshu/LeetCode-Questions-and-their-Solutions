class Solution {
    public int maxProduct(int[] arr) {
        int n = arr.length; 
        Arrays.sort(arr);
        return (arr[n-2] -1) * (arr[n-1] - 1);
    }
}