class Solution {
    
    public void dfs(int i, int j, char[][] grid, int n, int m){
        if(i >= n || j >= m || i < 0 || j < 0 || grid[i][j] == '0'){
            return ;
        }
        
        if(grid[i][j] == '1'){
            grid[i][j] = '0';
            
            dfs(i-1, j, grid, n, m);
            dfs(i+1, j, grid, n, m);
            dfs(i, j-1, grid, n, m);
            dfs(i, j+1, grid, n, m);
        }
    }
    public int numIslands(char[][] grid) {
        int ans = 0;
        
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid, grid.length, grid[0].length);
                    ans ++;
                }
            }
        }
        
        return ans;
    }
}