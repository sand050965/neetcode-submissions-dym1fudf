class Solution {
    Boolean[] dp;
    Set<String> set;

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        set = new HashSet<>(wordDict);
        dp = new Boolean[n + 1];
        dp[n] = true;
        
        return recurse(s, n, 0);
    }

    private boolean recurse(String s, int n, int idx) {
        if (dp[idx] != null) {
            return dp[idx];
        }

        for (int i = idx; i < n; i++) {
            String word = s.substring(idx, i + 1);
            if (set.contains(word) && recurse(s, n, i + 1)) {
                return dp[idx] = true;
            }
        }

        return dp[idx] = false;
    }
}
