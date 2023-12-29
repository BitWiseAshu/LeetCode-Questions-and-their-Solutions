public class Solution {
    private int[][] dp;

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }

        dp = new int[n][d + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(jobDifficulty, 0, d, n);
    }

    private int helper(int[] jobDifficulty, int index, int d, int n) {
        // BASE CASE
        if (d == 1) {
            int maxDifficulty = jobDifficulty[index];
            for (int i = index; i < n; i++) {
                maxDifficulty = Math.max(maxDifficulty, jobDifficulty[i]);
            }
            return maxDifficulty;
        }

        // Memoization
        if (dp[index][d] != -1) {
            return dp[index][d];
        }

        int maxD = jobDifficulty[index];
        int finalResult = Integer.MAX_VALUE;

        // RECURSIVE CALL
        // Try one by one with all possibilities
        for (int i = index; i <= n - d; i++) {
            maxD = Math.max(maxD, jobDifficulty[i]);
            int result = maxD + helper(jobDifficulty, i + 1, d - 1, n);
            finalResult = Math.min(finalResult, result);
        }

        dp[index][d] = finalResult;
        return finalResult;
    }
}