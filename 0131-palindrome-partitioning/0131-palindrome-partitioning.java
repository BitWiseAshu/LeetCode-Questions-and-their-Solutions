class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<List<String>>();

        if(s.length() == 0){
            return ans;
        }
        

        partitionHelper(ans, new ArrayList<String>(), s);
        return ans;
    }

    public void partitionHelper(List<List<String>> ans, ArrayList<String> res, String s){
        if(s.length() == 0){
            ans.add(new ArrayList<String>(res));
            return;
        }

        for(int i = 0; i < s.length(); i++){
            String prefix = s.substring(0, i+1);
            String postfix = s.substring(i+1, s.length());
            if(isPallindrome(prefix)){
                res.add(prefix);
                partitionHelper(ans, res, postfix);
                res.remove(res.size()-1);
            }
        }
    }

    public boolean isPallindrome(String s){
        int l = 0;
        int r =s.length()-1;

        while(l < r){
            char left = s.charAt(l);
            char right = s.charAt(r);

            if(left != right){
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}