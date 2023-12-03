class Solution {
    
    public boolean isValid(int i, int j, int n, int m, int[][] grid){
        if(i >= 0 && j >= 0 && i < n && j < m && grid[i][j] == 1){
            return true;
        }
        
        return false;
    }
    
    public void numEnclavesUsingDFS(int i, int j, int n, int m, int[][] grid){
        grid[i][j] = 0;
        
        // left
        if(isValid(i, j-1, n, m, grid)){
            numEnclavesUsingDFS(i, j-1, n, m, grid);
        }
        
        // right
        if(isValid(i, j+1, n, m, grid)){
            numEnclavesUsingDFS(i, j+1, n, m, grid);
        }
        
        // up
        if(isValid(i-1, j, n, m, grid)){
            numEnclavesUsingDFS(i-1, j, n, m, grid);
        }
        
        // down
        if(isValid(i+1, j, n, m, grid)){
            numEnclavesUsingDFS(i+1, j, n, m, grid);
        }
    }
    
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i = 0 ; i < n ; i++){
            
            // left
            int j = 0;
            if(grid[i][j] == 1){
                numEnclavesUsingDFS(i, j, n, m, grid);
            }
            
            // right
            j = m-1;
            if(grid[i][j] == 1){
                numEnclavesUsingDFS(i, j, n, m, grid);
            }
            
        } 
        
        for(int j = 0 ; j < m ; j++){
            
            // up
            int i = 0;
            if(grid[i][j] == 1){
                numEnclavesUsingDFS(i, j, n, m, grid);
            }
            
            // down
            i = n-1;
            if(grid[i][j] == 1){
                numEnclavesUsingDFS(i, j, n, m, grid);
            }
            
        } 
        
        return count(n, m, grid);
    }
    
    public int count(int n, int m, int [][]grid){
        
        int cnt = 0;
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(grid[i][j] == 1){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}