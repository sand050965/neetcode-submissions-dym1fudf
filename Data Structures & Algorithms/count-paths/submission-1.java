class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m + 1][n + 1];
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }

        return dfs(m, n, 0, 0);
    }

    private int dfs(int m, int n, int i, int j) {
        if (i == (m - 1) && j == (n - 1))
            return 1;

        if (memo[i][j] != -1)
            return memo[i][j];

        if (i >= m || j >= n)
            return 0;
        
        return memo[i][j] = dfs(m, n, i + 1, j) + dfs(m, n, i , j + 1);
    }
}
