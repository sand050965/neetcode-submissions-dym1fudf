class Solution {
    Set<String> set = new HashSet<>();
    Boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        memo = new Boolean[n + 1];
        memo[n] = true;

        for (String word : wordDict) {
            set.add(word);
        }

        return recurse(s, n, 0);
    }

    private boolean recurse(String s, int n, int startIdx) {
        if (memo[startIdx] != null) {
            return memo[startIdx];
        }
        
        if (startIdx >= n) {
            return true;
        }

        boolean result = false;

        for (int i = startIdx; i < n; i++) {
            String substr = s.substring(startIdx, i + 1);
            if (set.contains(substr)) {
                result |= recurse(s, n, i + 1);
            }
        }

        return memo[startIdx] = result;
    }
}
