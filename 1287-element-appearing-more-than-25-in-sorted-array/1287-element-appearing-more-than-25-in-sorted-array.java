class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int percent = n/4;
        
        int count = 1;
        for(int i = 1; i < n; i++){
            if(count > percent){
                return arr[i-1];
            }
            if(arr[i-1] != arr[i]){
                count = 1;
            }else{
                count ++;
            }
            
        }
        
        return arr[n-1];
    }
}