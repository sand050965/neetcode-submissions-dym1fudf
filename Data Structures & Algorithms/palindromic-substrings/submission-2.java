class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int result = 0;

        for (int l = n - 1; l >= 0; l--) {
            for (int r = l; r < n; r++) {
                if (
                    s.charAt(l) == s.charAt(r) 
                    && ((r - l <= 1) || dp[l + 1][r - 1])
                ) {
                    dp[l][r] = true;
                    result++;
                }
            }
        }

        return result;
    }
}
