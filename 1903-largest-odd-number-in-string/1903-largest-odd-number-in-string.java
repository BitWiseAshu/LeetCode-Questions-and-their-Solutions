class Solution {
    public String largestOddNumber(String num) {


        for(int i = num.length()-1; i >= 0; i--){
            char ch = num.charAt(i);
            String str = ch+"";
            int number = Integer.parseInt(str);
            
            if(number % 2 != 0){
                return num.substring(0,i+1);
            }
        }

        return "";
        
        
        
        
        
        

        // long number = Long.parseLong(num);
        
        // long ans = 0;
        
        // while(number > 0){
        //     if(number % 2 != 0){
        //         ans = number;
        //         break;
        //     }
        //     number = number / 10;
        // }
        
        // if(ans == 0){
        //     return "";
        // }
        // return Long.toString(ans);
    }
}