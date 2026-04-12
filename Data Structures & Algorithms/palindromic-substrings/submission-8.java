class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        int result = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1]));
                
                if (dp[i][j]) {
                    result++;
                }
            }
        }

        return result;
    }
}
