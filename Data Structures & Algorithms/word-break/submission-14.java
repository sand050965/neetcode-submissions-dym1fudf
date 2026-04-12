class Solution {
    int n;
    Map<Integer, Boolean> memo = new HashMap<>();
    Set<String> set = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        set = new HashSet<>(wordDict);

        return dfs(s, 0);
    }

    private boolean dfs(String s, int idx) {
        if (idx >= n) {
            memo.put(idx, true);
            return true;
        }

        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }

        for (int i = idx + 1; i <= n; i++) {
            String substr = s.substring(idx, i);
            if (set.contains(substr) && dfs(s, i)) {
                memo.put(idx, true);
                return true;
            }
        }

        memo.put(idx, false);
        return false;
    }
}
