class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        set.add(x + "," + y);
        
        char []charPath = path.toCharArray();
        
        for(char ch : charPath){
            if(ch =='N'){
                y ++;
            }
            else if(ch == 'S'){
                y --;
            }
            else if(ch == 'E'){
                x ++;
            }
            else if(ch == 'W'){
                x --;
            }
            
            String currentPoint = x + "," + y;
            
            if(set.contains(currentPoint)){
                return true;
            }
            
            set.add(currentPoint);
        }
        
        return false;
        
    }
}