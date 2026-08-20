class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int result = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (
                    s.charAt(i) == s.charAt(j) &&
                    ((j - i) <= 1 || dp[i + 1][j - 1])
                ) {
                    result++;
                    dp[i][j] = true;
                }
            }
        }

        return result;
    }
}
