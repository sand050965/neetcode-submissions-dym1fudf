class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 0;
        int startIdx = 0;
        int endIdx = 0;


        for (int l = n - 1; l >= 0; l--) {
            for (int r = l; r < n; r++) {
                if (
                    s.charAt(l) == s.charAt(r) 
                    && (r - l <= 1 || dp[l + 1][r - 1])
                ) {
                    dp[l][r] = true;

                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        startIdx = l;
                        endIdx = r;
                    }
                }
            }
        }

        return s.substring(startIdx, endIdx + 1);
    }
}
