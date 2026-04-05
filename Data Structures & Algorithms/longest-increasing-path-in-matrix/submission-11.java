class Solution {
    int ROWS;
    int COLS;
    int result = 1;
    Integer[][] dp;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        ROWS = matrix.length;
        COLS = matrix[0].length;
        dp = new Integer[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                result = Math.max(result, dfs(matrix, r, c, Integer.MIN_VALUE));
            }
        }

        return result;
    }

    private int dfs(int[][] matrix, int r, int c, int prev) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || matrix[r][c] <= prev) {
            return 0;
        }
        
        if (dp[r][c] != null) {
            return dp[r][c];
        }

        int res = 1;
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            res = Math.max(res, 1 + dfs(matrix, nr, nc, matrix[r][c]));
        }

        return dp[r][c] = res;
    }
}
