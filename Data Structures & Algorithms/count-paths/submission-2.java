class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[m - 1][n - 1] = 1;

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (r == m - 1 && c == n - 1) {
                    continue;
                }

                dp[r][c] = dp[r + 1][c] + dp[r][c + 1];
            }
        }

        return dp[0][0];
    }
}
