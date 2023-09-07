class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int [][]arr = new int[n][n];
        int k = 0;

        for(int j = 0 ; j < matrix[0].length; j++){
            int m = 0;
            for(int i = n-1; i >= 0; i--){
                arr[k][m] = matrix[i][j];
                m++;
            }
            k++;
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < n ;j++){
                matrix[i][j] = arr[i][j];
            }
        }
    }
}