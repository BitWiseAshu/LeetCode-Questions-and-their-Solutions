class Solution {
    public boolean isValid(int i, int j, char [][]board, int n, int m){
        if(i >=0 && i < n && j >= 0 && j < m && board[i][j] == 'O'){
            return true;
        }
        return false;
    }
    
    public void dfs(int i, int j, char [][]board, int n, int m){
        if(!isValid(i, j, board, n, m)){
            return;
        }
        board[i][j] = '#';
        
        dfs(i, j-1, board, n, m); // left
        dfs(i-1, j, board, n, m); // up
        dfs(i, j+1, board, n, m); //right
        dfs(i+1, j, board, n, m); // down
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O'){
                dfs(i, 0, board, n, m);
            }
            if(board[i][m-1] == 'O'){
                dfs(i, m-1, board, n, m);                
            }
        }
        
        for(int j = 0; j < m; j++){
            if(board[0][j] == 'O'){
                dfs(0, j, board, n, m);
            }
            if(board[n-1][j] == 'O'){
                dfs(n-1, j, board, n, m);
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}