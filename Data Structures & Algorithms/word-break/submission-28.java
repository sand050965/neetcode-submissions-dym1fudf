class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        Set<String> set = new HashSet<>();
        for (String word: wordDict) {
            set.add(word);
        }

        dp[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                String substr = s.substring(i, j + 1);
                if (set.contains(substr) && dp[j + 1]) {
                    dp[i] = true;
                    continue;
                }
            }
        }

        return dp[0];
    }
}
