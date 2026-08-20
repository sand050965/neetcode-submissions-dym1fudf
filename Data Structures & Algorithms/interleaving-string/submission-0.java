class Solution {
    Boolean[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 + n2 != n3)
            return false;

        memo = new Boolean[n1 + 1][n2 + 1];

        return dfs(s1, s2, s3, n1, n2, n3, 0, 0);
    }

    private boolean dfs(String s1, String s2, String s3, int n1, int n2, int n3, int i1, int i2) {
        if (i1 + i2 >= n3)
            return true;

        if (memo[i1][i2] != null)
            return memo[i1][i2];

        if (i1 < n1 && s1.charAt(i1) == s3.charAt(i1 + i2) && dfs(s1, s2, s3, n1, n2, n3, i1 + 1, i2))
            return memo[i1][i2] = true;
        
        if (i2 < n2 && s2.charAt(i2) == s3.charAt(i1 + i2) && dfs(s1, s2, s3, n1, n2, n3, i1, i2 + 1))
            return memo[i1][i2] = true;

        return memo[i1][i2] = false;
    }
}
