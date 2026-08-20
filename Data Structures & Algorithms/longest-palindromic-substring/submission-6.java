class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        int[] result = {0, 0};

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (
                    s.charAt(i) == s.charAt(j) &&
                    ((j - i) <= 1 || dp[i + 1][j - 1])
                ) {
                    dp[i][j] = true;
                    int len = j - i + 1;
                    if (len > max) {
                        max = Math.max(max, len);
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
        }

        return s.substring(result[0], result[1] + 1);
    }
}
