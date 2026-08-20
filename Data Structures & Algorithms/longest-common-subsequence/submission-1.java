class Solution {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        memo = new int[m][n];

        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }

        return dfs(text1, text2, m, n, 0, 0);
    }

    private int dfs(String text1, String text2, int m, int n, int i, int j) {
        if (i >= m || j >= n)
            return 0;
        
        if (memo[i][j] != -1)
            return memo[i][j];

        if (text1.charAt(i) == text2.charAt(j))
            return memo[i][j] = 1 + dfs(text1, text2, m, n, i + 1, j + 1);
        else
            return memo[i][j] = Math.max(
                dfs(text1, text2, m, n, i + 1, j),
                dfs(text1, text2, m, n, i, j + 1)
            );
    }
}
