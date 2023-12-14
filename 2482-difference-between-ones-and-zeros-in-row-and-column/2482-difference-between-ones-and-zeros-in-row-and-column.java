// This is also a correct code for this question but it gives time limit exceed
/*
class Solution {
    public int calculateDiff(int i, int j, int [][]grid){
        
        int onesRow = 0;
        int onesCol = 0;
        int zerosRow = 0;
        int zerosCol = 0;
        
        // for in row traversal 
        
        for(int tempj = 0 ; tempj < grid[0].length; tempj++){
            if(grid[i][tempj] == 1){
                onesRow ++;
            }
            else{
                zerosRow ++;
            }
        }
        
        // for in column traversal
        
        for(int tempi = 0; tempi < grid.length; tempi++){
            if(grid[tempi][j] == 1){
                onesCol ++;
            }
            else{
                zerosCol ++;
            }
        }
        
        return (onesRow + onesCol - zerosRow - zerosCol);
        
    }
    
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int ans[][] = new int[n][m];
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                int val = calculateDiff(i, j, grid);
                ans[i][j] = val;
            }
        }
        
        return ans;
    }
}
*/








class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] ans = new int[n][m];

        int[] onesRow = new int[n];
        int[] zerosRow = new int[n];
        int[] onesCol = new int[m];
        int[] zerosCol = new int[m];

        // Precalculate row and column sums
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1){
                    onesRow[i] += 1;
                    onesCol[j] += 1;
                }
                else{
                    zerosRow[i] += 1;
                    zerosCol[j] += 1;
                }
                
            }
        }

        // Calculate the difference using precomputed sums
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j];
            }
        }

        return ans;
    }
}