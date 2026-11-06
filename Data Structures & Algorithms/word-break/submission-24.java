class Solution {
    Boolean[] dp;
    Set<String> set = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        dp = new Boolean[n + 1];
        dp[n] = true;
        for (String word : wordDict) {
            set.add(word);
        }

        return recurse(s, n, 0);
    }

    private boolean recurse(String s, int n, int idx) {
        if (dp[idx] != null) {
            return dp[idx];
        }

        for (int i = idx; i < n; i++) {
            String word = s.substring(idx, i + 1);
            int len = word.length();
            if (set.contains(word) && recurse(s, n, idx + len)) {
                return dp[idx] = true;
            }
        }

        return dp[idx] = false;
    }
}
