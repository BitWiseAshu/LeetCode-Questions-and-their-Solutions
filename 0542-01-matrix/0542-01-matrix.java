class Solution {
    
    class Pair{
        int row;
        int col;
        
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        boolean [][]visited = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        
        for(int i = 0 ;  i < n; i++){
            for(int j = 0 ; j  < m ; j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j));
                    visited[i][j] = true;
                }
                
            }
        }
        
        while (!q.isEmpty()) {
            Pair frontElement = q.poll();
            int rowIndex = frontElement.row;
            int colIndex = frontElement.col;

            visited[rowIndex][colIndex] = true;

            // left
            if (isValid(rowIndex, colIndex - 1, n, m) && !visited[rowIndex][colIndex - 1]) {
                mat[rowIndex][colIndex - 1] = mat[rowIndex][colIndex] + 1;
                q.add(new Pair(rowIndex, colIndex - 1));
                visited[rowIndex][colIndex - 1] = true;  
            }

            // right
            if (isValid(rowIndex, colIndex + 1, n, m) && !visited[rowIndex][colIndex + 1]) {
                mat[rowIndex][colIndex + 1] = mat[rowIndex][colIndex] + 1;
                q.add(new Pair(rowIndex, colIndex + 1));
                visited[rowIndex][colIndex + 1] = true;
            }

            // up
            if (isValid(rowIndex - 1, colIndex, n, m) && !visited[rowIndex - 1][colIndex]) {
                mat[rowIndex - 1][colIndex] = mat[rowIndex][colIndex] + 1;
                q.add(new Pair(rowIndex - 1, colIndex));
                visited[rowIndex - 1][colIndex] = true;
            }

            // down
            if (isValid(rowIndex + 1, colIndex, n, m) && !visited[rowIndex + 1][colIndex]) {
                mat[rowIndex + 1][colIndex] = mat[rowIndex][colIndex] + 1;
                q.add(new Pair(rowIndex + 1, colIndex));
                visited[rowIndex + 1][colIndex] = true;
            }
        }       

        return mat;

    }
    
    public boolean isValid(int rowIndex, int colIndex, int n, int m){
        if(rowIndex >=0 && colIndex >= 0 && rowIndex < n && colIndex < m){
            return true;
        }
        
        return false;
    }
}