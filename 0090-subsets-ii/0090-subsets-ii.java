class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        subsetsWithDupHelper(ans, nums, new ArrayList<>(), 0);
        return ans;
    }

    public void subsetsWithDupHelper(List<List<Integer>> ans, int[] nums, ArrayList<Integer> list, int n){

        if(n == nums.length){
            Collections.sort(list);
            if(!ans.contains(new ArrayList<>(list))){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        list.add(nums[n]);
        subsetsWithDupHelper(ans, nums, list, n+1);
        list.remove(list.size()-1);

        subsetsWithDupHelper(ans, nums, list, n+1);
    }
}



// public class Solution {

//     public void findSubsets(int left, int right, int size, int[] nums, List<List<Integer>> arr) {
//         List<Integer> temp = new ArrayList<>();

//         for (int i = left; i <= right; i++) {
//             temp.add(nums[i]);
//         }

//         if (!arr.contains(temp)) {
//             arr.add(new ArrayList<>(temp));
//         }

//         if (left == right) {
//             return;
//         }

//         int mid = -1;
//         if (size % 2 == 1) {
//             mid = (size + 1) / 2;
//         } else {
//             mid = size / 2;
//         }

//         findSubsets(0, mid - 1, mid, nums, arr);
//         findSubsets(mid, nums.length - 1, mid, nums, arr);
//     }
         
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         List<List<Integer>> arr = new ArrayList<>();
//         Arrays.sort(nums);
//         findSubsets(0, nums.length - 1, nums.length, nums, arr);
//         return arr;
//     }

// }