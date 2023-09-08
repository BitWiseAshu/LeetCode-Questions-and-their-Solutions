class Solution {
    public boolean rotateString(String s, String goal) {
        /* 
        // FIRST METHOD
        
        if(s.length() != goal.length()){
            return false;
        }
        
        String str = s+s;
        if(str.contains(goal)){
            return true;
        }
        
        return false; 
        */
        
        
        
        //SECOND METHOD
        
        if (s.length() != goal.length()){
            return false;
        }
        if (s.equals(goal)){
            return true;
        }
        
        for (int i = 1; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(1)).append(s.charAt(0));
            s = sb.toString();
            if (s.equals(goal)) return true;
            sb.setLength(0);
        }
        return false;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        char ch = s.charAt(0);
        
        int index = -1;
        for(int i = 0 ; i< goal.length(); i++){
            if(ch == goal.charAt(i)){
                index = i;
                break;
            }
        }
        
        String subStr = goal.substring(index);
        int subsLen = subStr.length();
        
        String newSubStr = "";
        for(int i = subsLen; i< s.length(); i++){
            newSubStr += s.charAt(i);
        }
        newSubStr += subStr;
        System.out.println(newSubStr);
        
        if(newSubStr.equals(goal)){
            return true;
        }
        return false;
        */
        
    }
}