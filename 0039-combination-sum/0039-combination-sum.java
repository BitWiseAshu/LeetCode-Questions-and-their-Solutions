// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> ans = new ArrayList<>();
//         Arrays.sort(candidates);
//         // int n = nums.length;
//         subsetsWithDupHelper(ans, candidates, new ArrayList<>(), 0, target);
//         return ans;
//     }
    
//     public void subsetsWithDupHelper(List<List<Integer>> ans, int[] nums, ArrayList<Integer> list, int n, int target){

//         if(n == nums.length){
//             Collections.sort(list);
            
//             int sum = 0;
//             for(int i = 0 ; i < list.size(); i++){
//                 sum = sum + list.get(i);
//             }
            
//             int tempSum = target - sum;
//             boolean flag = false;
//             for(int i = 0 ; i  < nums.length; i++){
//                 if(nums[i] == tempSum){
//                     flag = true;
//                     break;
//                 }
//             }
            
//             if(((!ans.contains(new ArrayList<>(list)) && sum == target) || (!ans.contains(new ArrayList<>(list)) && flag) ) && (target != 0 && sum != 0 )){
//                 ans.add(new ArrayList<>(list));
//             }
//             return;
//         }

//         list.add(nums[n]);
//         subsetsWithDupHelper(ans, nums, list, n+1, target);
//         list.remove(list.size()-1);

//         subsetsWithDupHelper(ans, nums, list, n+1, target);
//     }
// }








// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> ans = new ArrayList<>();
//         Arrays.sort(candidates);
//         subsetsWithDupHelper(ans, candidates, new ArrayList<>(), target, 0, 0);
//         return ans;
//     }
    
//     public void subsetsWithDupHelper(List<List<Integer>> ans, int []arr, List<Integer> list, int target, int sum, int index){
//         if(index == arr.length){
//             System.out.println("yes");
//             if(sum == target){
//                 ans.add(new ArrayList<>(list));
//             }
//             return;
//         }
        
//         if(arr[index] <= sum){
//             list.add(arr[index]);
//             subsetsWithDupHelper(ans, arr, list, target, sum+arr[index], index);
//             list.remove(list.size()-1);
//         }
        
//         subsetsWithDupHelper(ans, arr, list, target, sum, index+1);
//     }
// }








class Solution {

    private void findCombinations(int ind, int[] arr, int target, List < List < Integer >> ans, List < Integer > ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList < > (ds));
            }
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(ind + 1, arr, target, ans, ds);
    }
    public List < List < Integer >> combinationSum(int[] candidates, int target) {
        List < List < Integer >> ans = new ArrayList < > ();
        findCombinations(0, candidates, target, ans, new ArrayList < > ());
        return ans;
    }
}