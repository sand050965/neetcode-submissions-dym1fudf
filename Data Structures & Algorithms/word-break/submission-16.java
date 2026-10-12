class Solution {
    Set<String> set = new HashSet<>();
    Map<Integer, Boolean> dp = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        for (String word : wordDict) {
            set.add(word);
        }

        return recurse(s, n, 0);
    }

    private boolean recurse(String s, int n, int startIdx) {
        if (dp.containsKey(startIdx)) {
            return dp.get(startIdx);
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

        dp.put(startIdx, result);
        
        return result;
    }
}
