class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        int len = 0;
        int[] indexes = {-1, -1};

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) && ((j - i <= 1) || dp[i + 1][j - 1]));

                if (dp[i][j] && (j - i + 1) > len) {
                    len = Math.max(len, j - i + 1);
                    indexes[0] = i;
                    indexes[1] = j;
                }
            }
        }

        return s.substring(indexes[0], indexes[1] + 1);
    }
}
