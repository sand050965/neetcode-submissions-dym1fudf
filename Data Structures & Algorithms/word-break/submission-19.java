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

        for (int i = idx; i < n; i++) {
            String substr = s.substring(idx, i + 1);
            if (set.contains(substr) && recurse(s, n, i + 1)) {
                return memo[idx] = true;
            }
        }

        return memo[idx] = false;
    }
}
