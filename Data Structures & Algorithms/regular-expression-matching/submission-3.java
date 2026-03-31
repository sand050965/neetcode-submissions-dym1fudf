class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;
        
        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                boolean match = (i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

                if (match) {
                    dp[i][j] = dp[i + 1][j + 1];

                    if (j + 1 < n && p.charAt(j + 1) == '*') {
                        dp[i][j] |= (dp[i + 1][j] || dp[i][j + 2]);
                    }
                } else {
                    if (j + 1 < n && p.charAt(j + 1) == '*') {
                        dp[i][j] = dp[i][j + 2];
                    }
                }
            }
        }

        return dp[0][0];
    }
}
