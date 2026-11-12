class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (String word : set) {
                int len = word.length();
                if (s.startsWith(word, i)) {
                    dp[i] = dp[i + len];
                }

                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[0];
    }
}
