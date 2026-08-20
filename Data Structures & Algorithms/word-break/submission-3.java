class Solution {
    Map<Integer, Boolean> memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        memo = new HashMap<>();
        memo.put(n, true);

        return dfs(s, wordDict, n, 0);
    }

    private boolean dfs(String s, List<String> wordDict, int n, int i) {
        if (memo.containsKey(i))
            return memo.get(i);
        

        for (String word: wordDict) {
            int len = word.length();
            if (i + len <= n && s.substring(i, i + len).equals(word)) {
                if (dfs(s, wordDict, n, i + len)) {
                    memo.put(i, true);
                    return true;
                }
            }
        }

        memo.put(i, false);
        return false;
    }
}
