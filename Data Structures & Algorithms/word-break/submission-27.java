class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                String word = s.substring(i, j + 1);
                if (set.contains(word) && dp[j + 1]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
