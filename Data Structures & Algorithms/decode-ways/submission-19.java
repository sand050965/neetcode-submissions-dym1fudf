class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            char ch1 = s.charAt(i);
            if (ch1 == '0') {
                continue;
            }

            dp[i] += dp[i + 1];
            
            if (i + 2 > n) {
                continue;
            }

            char ch2 = s.charAt(i + 1);
            if (ch1 == '1' || (ch1 == '2' && ch2 <= '6')) {
                dp[i] += dp[i + 2];
            }
        }

        return dp[0];
    }
}
