/*
public class Solution {
    
    private int minFallingPathSumUsingMemoization(int[][] arr, int i, int j, int m, int n, int[][] dp) {
        if (i == m - 1) {
            return arr[i][j]; 
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int diagonalLeft = Integer.MAX_VALUE;
        int diagonalRight = Integer.MAX_VALUE;
    
        int down = arr[i][j] + minFallingPathSumUsingMemoization(arr, i + 1, j, m, n, dp);
        
        if (j + 1 < n) {
            diagonalRight = arr[i][j] + minFallingPathSumUsingMemoization(arr, i + 1, j + 1, m, n, dp);
        }
        if (j - 1 >= 0) {
            diagonalLeft = arr[i][j] + minFallingPathSumUsingMemoization(arr, i + 1, j - 1, m, n, dp);
        }

        int min = Math.min(down, Math.min(diagonalLeft, diagonalRight));
        dp[i][j] = min;
        
        return dp[i][j];
    }

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        int minSum = Integer.MAX_VALUE;

        for (int j = 0; j < n; ++j) {
            int ans = minFallingPathSumUsingMemoization(matrix, 0, j, m, n, dp);
            minSum = Math.min(minSum, ans);
        }

        return minSum;
    }
}
*/









public class Solution {
    
    private int minFallingPathSumRecursive(int[][] matrix, int row, int col, int[][] dp) {
        if (row >= matrix.length || col >= matrix[0].length || col < 0) {
            return Integer.MAX_VALUE;
        }
        
        if (row == matrix.length - 1) {
            if (col < matrix[0].length && col >= 0) {
                return matrix[row][col];
            }
            else{ 
                return 0;
            }
        }

        if (dp[row][col] != Integer.MIN_VALUE) {
            return dp[row][col];
        }

        return dp[row][col] = matrix[row][col] + Math.min(
                minFallingPathSumRecursive(matrix, row + 1, col, dp),
                Math.min(minFallingPathSumRecursive(matrix, row + 1, col - 1, dp),
                        minFallingPathSumRecursive(matrix, row + 1, col + 1, dp)));
        // Calculate and store in the memoization matrix
//         int down = matrix[row][col] + minFallingPathSumRecursive(matrix, row + 1, col, dp);
//         int downRight = matrix[row][col] + minFallingPathSumRecursive(matrix, row + 1, col - 1, dp);
//         int downLeft = matrix[row][col] +minFallingPathSumRecursive(matrix, row + 1, col + 1, dp);
        
//         int min = Math.min(down, Math.min(downRight, downLeft));
//         dp[row][col] = min;
        
//         return dp[row][col];
    }

    public int minFallingPathSum(int[][] matrix) {
        // Memoization matrix creation
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            result = Math.min(result, minFallingPathSumRecursive(matrix, 0, i, dp));
        }
        return result;
    }
}
