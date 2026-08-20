class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (String word : wordDict) {
                int len = word.length();

                if (i + len > n) {
                    continue;
                }

                String substr = s.substring(i, i + len);
                dp[i] = (substr.equals(word)) && dp[i + len];

                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[0];
    }
}
