class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image.length == 0 || image == null){
            return image;
        }
        
        int n = image.length;
        int m = image[0].length;
        
        // Intializing a array of Queue
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        int sameColor = image[sr][sc];
        image[sr][sc] = color;
        
        while (!q.isEmpty()){
            int front[] = q.poll();
            
            int i = front[0];
            int j = front[1];
            
            // left
            int leftI = i;
            int leftJ = j - 1;
            
            if(leftI >= 0 && leftJ >= 0 && leftI < n && leftJ < m && image[leftI][leftJ] == sameColor){
                image[leftI][leftJ] = -999;
                q.add(new int[]{leftI, leftJ});
            }
            
            // right 
            int rightI = i;
            int rightJ= j + 1;
            
            if(rightI >= 0 && rightJ >= 0 && rightI < n && rightJ < m && image[rightI][rightJ] == sameColor){
                image[rightI][rightJ] = -999;
                q.add(new int[]{rightI, rightJ});
            }
            
            // up
            int topI = i - 1;
            int topJ = j;
            
            if(topI >= 0 && topJ >= 0 && topI < n && topJ < m && image[topI][topJ] == sameColor){
                image[topI][topJ] = -999;
                q.add(new int[]{topI, topJ});
            }
            
            // down
            int bottomI = i+1;
            int bottomJ = j;
            
            if(bottomI >= 0 && bottomJ >= 0 && bottomI < n && bottomJ < m && image[bottomI][bottomJ] == sameColor){
                image[bottomI][bottomJ] = -999;
                q.add(new int[]{bottomI, bottomJ});
            }
        
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(image[i][j] == -999){
                    image[i][j] = color;
                }
            }
        }
        
        return image;
    }
}