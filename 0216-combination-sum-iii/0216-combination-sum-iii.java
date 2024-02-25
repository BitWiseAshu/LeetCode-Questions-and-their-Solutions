class Solution {
    
    public void backtrack(int k, int n, List<List<Integer>> ans, List<Integer> list, int start, int sum){
        if(list.size() == k){
            if(sum == n){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        
        for(int i = start ; i < 10; i++){
            if(sum+i <= n){
                list.add(i);
                backtrack(k, n, ans, list, i+1, sum+i);
                list.remove(list.size()-1);
            }else break;
            
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        
        backtrack(k, n, ans, new ArrayList<>(), 1, 0);
        return ans;
    }
}



