class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int m = s.length();
        boolean[] dp = new boolean[m + 1];
        dp[m] = true;

        for (int i = m - 1; i >= 0; i--) {
            for (String word : wordDict) {
                int n = word.length();

                if (i + n > m) {
                    continue;
                }

                String substr = s.substring(i, i + n);
                dp[i] = word.equals(substr) && dp[i + n];
                
                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[0];
    }
}
