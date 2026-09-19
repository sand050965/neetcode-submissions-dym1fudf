class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int resIdx = 0, resLen = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                int len = j - i + 1;
                if (s.charAt(i) == s.charAt(j) && (len <= 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    if (resLen < len) {
                        resLen = len;
                        resIdx = i;
                    }
                }
            }
        }

        return s.substring(resIdx, resIdx + resLen);
    }
}
