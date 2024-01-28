class Pair{
    int i;
    int j;
    int dist = 0;
    
    Pair(int i, int j, int dist){
        this.i = i;
        this.j = j;
        this.dist = dist;
    }
}
class Solution {
    
    public boolean isValid(int row, int col, int n, int [][]grid, int distance, int arr[][]){
        if(row >= 0 && row < n && col >= 0 && col < n && grid[row][col] != 1 && distance+1 < arr[row][col]) {
            return true;
        }    
        
        return false;
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        if(grid[n-1][n-1] != 0 || grid[0][0] != 0){
            return -1;
        }
        
        if(n-1 == 0){
            return 1;
        }
        
        int [][]arr = new int[n][n];
        for(int []a : arr){
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        
        arr[0][0] = 1;
        
        int x[] = {0, -1, -1, -1, 0, 1, 1, 1};
        int y[] = {-1, -1, 0, 1, 1, 1, 0, -1};
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1));
        
        while(!q.isEmpty()){
            Pair front = q.poll();
            int row = front.i;
            int col = front.j;
            int distance = front.dist;
            
            for(int i = 0 ; i < 8; i++){
                int currRow = row + x[i];
                int currCol = col + y[i];
                
                if (isValid(currRow, currCol, n, grid, distance, arr)){
                    arr[currRow][currCol] = 1 + distance;
                    
                    if(currRow == n-1 && currCol == n-1){
                        return arr[currRow][currCol];
                    }
                    
                    q.add(new Pair(currRow, currCol, 1+distance));
                    grid[currRow][currCol] = 1;
                }
                
            }
            
        }
        
        return -1;
        
    }
}