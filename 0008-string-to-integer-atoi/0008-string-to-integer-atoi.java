class Solution {
    public int myAtoi(String s) {
      s = s.trim();

      int i = 0;
      int n = s.length();

      int negativeSign = 0;
      int positiveSign = 0;

      while(i < n && s.charAt(i) == '-'){
        i++;
        negativeSign++;
      }

      while(i < n && s.charAt(i) == '+'){
        i++;
        positiveSign++;
      }

      double ans = 0;

      while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
        ans = ans * 10 + (s.charAt(i) - '0'); //(s[i] - '0') is converting character to integer
        i++;
      }

      if(negativeSign > 0){
        ans = -ans;
      }

      if(positiveSign > 1 || negativeSign > 1){
        return 0;
      }

      if(positiveSign > 0 && negativeSign > 0){
        return 0;
      }

      int max = Integer.MAX_VALUE;
      int min = Integer.MIN_VALUE;

      if(ans > max){
        return max;
      }

      if(ans < min){
        return min;
      }

      return (int)ans;
    }
}