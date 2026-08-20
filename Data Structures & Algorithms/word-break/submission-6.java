class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int m = s.length(), n = wordDict.size();
        boolean[] dp = new boolean[m + 1];
        dp[m] = true;

        for (int i = m - 1; i >= 0; i--) {
            for (String word : wordDict) {
                int w = word.length();
                if (i + w <= m && s.substring(i, i + w).equals(word)) {
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
