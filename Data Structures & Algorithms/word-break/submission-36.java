class Solution {
    Boolean[] dp;
    Set<String> set;

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        dp = new Boolean[n + 1];
        set = new HashSet<>(wordDict);    
        dp[n] = true;

        return recurse(s, n, 0);
    }

    private boolean recurse(String s, int n, int idx) {
        if (idx >= n) {
            return true;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }

        for (String word : set) {
            int len = word.length();
            if (s.startsWith(word, idx) && recurse(s, n, idx + len)) {
                return dp[idx] = true;
            }
        }

        return dp[idx] = false;
    }
}
