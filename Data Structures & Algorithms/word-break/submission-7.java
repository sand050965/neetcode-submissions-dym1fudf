class Solution {
    int n;
    Boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        memo = new Boolean[n + 1];

        return dfs(s, wordDict, 0);
    }

    private boolean dfs(String s, List<String> wordDict, int idx) {
        if (memo[idx] != null) {
            return memo[idx];
        }

        if (idx == n) {
            return true;
        }

        for (String word : wordDict) {
            int w = word.length();
            if (idx + w <= n && s.substring(idx, idx + w).equals(word)) {
                if (dfs(s, wordDict, idx + w)) {
                    return memo[idx] = true;
                }
            }
        }

        return memo[idx] = false;
    }
}
