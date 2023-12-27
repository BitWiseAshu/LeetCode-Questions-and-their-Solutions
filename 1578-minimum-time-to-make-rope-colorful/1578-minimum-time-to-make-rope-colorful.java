class Solution {
    public int minCost(String s, int[] neededTime) {
        int sum = 0;
        char curr = s.charAt(0);
        int maxTime = neededTime[0];
        
        for(int i = 1;i<neededTime.length;i++){
            if(curr == s.charAt(i)){
                if(neededTime[i]>maxTime){
                    sum+=maxTime;
                    maxTime = neededTime[i];
                }else{
                    sum+=neededTime[i];
                }
            }else{
                curr = s.charAt(i);
                maxTime = neededTime[i];
            }
        }
        return sum;
        
       
    }
}