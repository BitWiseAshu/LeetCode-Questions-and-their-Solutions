class Solution {
    
    public boolean isValid(int i, int j, int [][]arr){
        if(i >=0 && j >= 0 && i < arr.length && j < arr[0].length){
            return true;
        }
        return false;
    }
    
    public int checkValid(int i, int j, int [][]arr, int []x, int []y){
        int ans = 0;
        int count = 1;
        for(int k = 0; k < 8; k++){
            int xi = i + x[k];
            int yj = j + y[k];
            
            if(isValid(xi, yj, arr)){
                ans += arr[xi][yj];
                count ++;
            }
        }
        ans = ans + arr[i][j];
        
        return (ans/count);
    }
    
    public int[][] imageSmoother(int[][] img) {
        int []x = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
        int []y = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        int[][] result = new int[img.length][img[0].length];
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                int currentAns = checkValid(i, j, img, x, y);
                result[i][j] = currentAns;
            }
        }
        
        return result;
    }
}