class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int arr[] = new int[m+n];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < n && j < m){
            if(nums1[i] >= nums2[j]){
                arr[k] = nums2[j];
                j++;
            }
            else if(nums1[i] < nums2[j]){
                arr[k] = nums1[i];
                i++;
            }
            k++;
        }

        while(i < n){
            arr[k] = nums1[i];
            k++;
            i++;
        }

        while(j < m){
            arr[k] = nums2[j];
            k++;
            j++;
        }

        int len = arr.length;
        double median = 0;

        if(len % 2 == 0){
            median = ( arr[(len/2)-1] + arr[len/2] )/2.0;
        }
        else{
            median = arr[len/2];
        }
        return median;
    }
}