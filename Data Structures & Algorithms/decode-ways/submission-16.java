class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '0') {
                continue;
            }

            dp[i] = dp[i + 1];

            if (i + 1 < n && (ch == '1' || (ch == '2' && s.charAt(i + 1) <= '6'))) {
                dp[i] += dp[i + 2];
            }
        }

        return dp[0];
    }
}
