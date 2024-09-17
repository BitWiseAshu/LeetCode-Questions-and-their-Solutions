// Backtracking solution

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        solve(0, board, result, n);
        return result;
    }
    
    private void solve(int col, char[][] board, List<List<String>> result, int n) {
        if (col == n) {
            result.add(construct(board)); // If all columns are filled, add the solution to result
            return;
        }
        
        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q'; 
                solve(col + 1, board, result, n); 
                board[row][col] = '.'; 
            }
        }
    }
    
    private boolean isSafe(char[][] board, int row, int col, int n) {
        // Check if any queen is placed in the same row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') return false;
        }
        
        // Check the upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        
        // Check the lower left diagonal
        for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }
        
        return true;
    }
    
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}




// optimal solution


// class Solution {
//     public List<List<String>> solveNQueens(int n) {
//         List<List<String>> result = new ArrayList<>();
//         char[][] board = new char[n][n];
        
//         for (int i = 0; i < n; i++) {
//             Arrays.fill(board[i], '.');
//         }
        
//         int sameRow[] = new int[n];
//         int upperDiagonal[] = new int[(2*n)-1];
//         int lowerDiagonal[] = new int[(2*n)-1];
        
//         solve(0, board, result, n, sameRow, upperDiagonal, lowerDiagonal);
//         return result;
//     }
    
//     private void solve(int col, char[][] board, List<List<String>> result, int n, int sameRow[], int upperDiagonal[], int lowerDiagonal[]) {
//         if (col == n) {
//             result.add(construct(board)); // If all columns are filled, add the solution to result
//             return;
//         }
        
//         for (int row = 0; row < n; row++) {
//             if (isSafe(board, row, col, n, sameRow, upperDiagonal, lowerDiagonal)) {
//                 board[row][col] = 'Q'; 
//                 solve(col + 1, board, result, n, sameRow, upperDiagonal, lowerDiagonal); 
//                 board[row][col] = '.'; 
//             }
//         }
//     }
    
//     private boolean isSafe(char[][] board, int row, int col, int n, int sameRow[], int upperDiagonal[], int lowerDiagonal[]) {
//         if(sameRow[row] == 0 || upperDiagonal[n-1+col-row] == 0 || lowerDiagonal[row+col] == 0){
//             return true;
//         }
        
//         return false;
//     }
    
//     private List<String> construct(char[][] board) {
//         List<String> res = new ArrayList<>();
//         for (int i = 0; i < board.length; i++) {
//             res.add(new String(board[i]));
//         }
//         return res;
//     }
// }
