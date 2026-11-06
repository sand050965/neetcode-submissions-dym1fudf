class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for (String word : wordDict) {
            set.add(word);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                String word = s.substring(i, j + 1);
                int len = word.length();

                if (set.contains(word) && dp[i + len]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
