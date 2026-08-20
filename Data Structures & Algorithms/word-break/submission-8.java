class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (String word : wordDict) {
                int w = word.length();
                if (i + w <= n && s.substring(i, i + w).equals(word)) {
                    dp[i] = dp[i + w];
                }

                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[0];
    }
}
