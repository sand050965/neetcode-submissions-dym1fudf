class Solution {
    Boolean[] memo;
    Set<String> set = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        memo = new Boolean[n];
        for (String word : wordDict) {
            set.add(word);
        }

        return recurse(s, n, 0);
    }

    private boolean recurse(String s, int n, int idx) {
        if (idx >= n) {
            return true;
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        for (String word : set) {
            int len = word.length();
            if (idx + len > n) {
                continue;
            }

            String substr = s.substring(idx, idx + len);
            if (idx + len <= n && set.contains(substr) && recurse(s, n, idx + len)) {
                return memo[idx] = true;
            }
        }

        return memo[idx] = false;
    }
}
