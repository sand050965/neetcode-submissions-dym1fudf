class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    Integer[][] memo;
    int ROWS;
    int COLS;

    public int longestIncreasingPath(int[][] matrix) {
        ROWS = matrix.length;
        COLS = matrix[0].length;
        memo = new Integer[ROWS][COLS];

        int result = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                result = Math.max(result, dfs(matrix, r, c, Integer.MIN_VALUE));
            }
        }

        return result;
    }

    private int dfs(int[][] matrix, int r, int c, int prev) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || matrix[r][c] <= prev)
            return 0;

        if (memo[r][c] != null)
            return memo[r][c];

        int result = 1;
        for (int[] dir: dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            result = Math.max(result, 1 + dfs(matrix, nr, nc, matrix[r][c]));
        }

        return memo[r][c] = result;
    }
}
