class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        subsetsWithDupHelper(ans, candidates, new ArrayList<>(), target, 0, 0);
        return ans;
    }
    
    public void subsetsWithDupHelper(List<List<Integer>> ans, int[] arr, List<Integer> list, int target, int sum, int index) {
        if (sum == target) {
            ans.add(new ArrayList<>(list)); // Add a copy of the list
            return;
        }
        
        if (sum > target || index == arr.length) {
            return;
        }
        
        list.add(arr[index]);
        subsetsWithDupHelper(ans, arr, list, target, sum + arr[index], index); // Include the current element
        list.remove(list.size() - 1);
        
        subsetsWithDupHelper(ans, arr, list, target, sum, index + 1); // Skip the current element
    }
}





/*

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
*/