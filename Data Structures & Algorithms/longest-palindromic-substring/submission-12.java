class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int resultLen = 0, startIdx = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                int len = j - i + 1;
                if (s.charAt(i) == s.charAt(j) && (len <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }

                if (dp[i][j] && len > resultLen) {
                    resultLen = len;
                    startIdx = i;
                }
            }
        }

        return s.substring(startIdx, startIdx + resultLen);
    }
}
