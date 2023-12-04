class Solution {
    public boolean isUnique(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public String largestGoodInteger(String num) {
        HashSet<String> hs = new HashSet<>();
        String ans = "";

        for (int i = 0; i <= num.length() - 3; i++) {
            String str = num.substring(i, i + 3);

            if (isUnique(str)) {
                if (str.compareTo(ans) > 0) {
                    ans = str;
                }
            }
        }
        return ans;
    }
}