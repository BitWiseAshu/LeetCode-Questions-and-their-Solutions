class Solution {
    public boolean searchWord(char[][] board, String word, int n, int m, int row, int col, int index){
        if(index == word.length()){
            return true;
        }
        
        if(row < 0 || col < 0 || row >= n || col >= m || word.charAt(index) != board[row][col] || board[row][col] == '\U0001f44e'){
            return false;
        }
        
        char ch = word.charAt(index);
        board[row][col] = '\U0001f44e';
        
        boolean top = searchWord(board, word, n, m, row-1, col, index+1);
        boolean left = searchWord(board, word, n, m, row, col+1, index+1);
        boolean down = searchWord(board, word, n, m, row+1, col, index+1);
        boolean right = searchWord(board, word, n, m, row, col-1, index+1);
        
        board[row][col] = ch;
        return top || left || down || right;
    }
    
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(word.charAt(0) == board[i][j]){
                    if(searchWord(board, word, n, m, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}