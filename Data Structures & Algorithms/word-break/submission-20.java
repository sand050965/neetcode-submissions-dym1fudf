class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (String word : wordDict) {
            set.add(word);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (String word : set) {
                int len = word.length();

                if (i + len > n) {
                    continue;
                }
                
                String substr = s.substring(i, i + len);
                dp[i] = set.contains(substr) && dp[i + len];

                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[0];
    }
}
