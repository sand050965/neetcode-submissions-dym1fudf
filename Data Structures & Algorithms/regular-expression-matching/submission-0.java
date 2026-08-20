class Solution {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        memo = new Boolean[m + 1][n + 1];

        return dfs(s, p, m, n, 0, 0);
    }

    private boolean dfs(String s, String p, int m, int n, int i, int j) {
        if (i >= m && j >= n)
            return true;

        if (j >= n)
            return false;

        if (memo[i][j] != null)
            return memo[i][j];

        boolean match = (i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
        if (j + 1 < n && p.charAt(j + 1) == '*')
            return memo[i][j] = dfs(s, p, m, n, i, j + 2) || (match && dfs(s, p, m, n, i + 1, j));
        if (match)
            return memo[i][j] = dfs(s, p, m, n, i + 1, j + 1);

        return memo[i][j] = false;
    }
}
