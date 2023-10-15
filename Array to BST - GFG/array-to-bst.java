//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
        ArrayList<Integer> list = new ArrayList<>();
        convertToBST(nums, list, 0, nums.length-1);
        
        int ans[] = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++){
            ans[i] = list.get(i);
        }
        
        return ans;
        
    }
    public void convertToBST(int []arr, ArrayList<Integer> list, int start, int end){
        if(start > end){
            return;
        }
        
        int mid = (start + end)/ 2;
        list.add(arr[mid]);
        
        convertToBST(arr, list, start, mid-1);
        convertToBST(arr, list, mid+1, end);
    }
    
}