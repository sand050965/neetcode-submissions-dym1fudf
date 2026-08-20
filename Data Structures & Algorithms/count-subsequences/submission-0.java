class Solution {
    Integer[][] memo;
    public int numDistinct(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        
        if (n1 < n2)
            return 0;

        memo = new Integer[n1 + 1][n2 + 1];

        return dfs(s, t, n1, n2, 0, 0);
    }

    private int dfs(String s, String t, int n1, int n2, int i1, int i2) {
        if (i2 == n2)
            return 1;
        
        if (i1 == n1)
            return 0;
        
        if (memo[i1][i2] != null)
            return memo[i1][i2];

        memo[i1][i2] = dfs(s, t, n1, n2, i1 + 1, i2);
        if (s.charAt(i1) == t.charAt(i2))
            memo[i1][i2] += dfs(s, t, n1, n2, i1 + 1, i2 + 1);

        return memo[i1][i2];
    }
}
