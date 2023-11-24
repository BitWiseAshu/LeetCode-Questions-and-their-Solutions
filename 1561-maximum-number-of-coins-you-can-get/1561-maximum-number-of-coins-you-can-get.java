class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < piles.length; i++){
            list.add(piles[i]);
        }
        Collections.reverse(list);
        int i = 1;
        int j = list.size()-1;
        
        int ans = 0;
        
        while(i < j){
            ans += list.get(i);
            i = i+2;
            j--;
        }
        
        return ans;
    }
    
}