class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] dp = new int[n + 1];
        for (int i = n; i >= 0; i--)
            dp[i] = n - i;

        for (int i = m - 1; i >= 0; i--) {
            int nextDP = dp[n];
            dp[n] = m - i;
            for (int j = n - 1; j >= 0; j--) {
                int temp = dp[j];

                if (word1.charAt(i) == word2.charAt(j))
                    dp[j] = nextDP;
                else
                    dp[j] = 1 + Math.min(
                        dp[j],
                        Math.min(dp[j + 1], nextDP)
                    );
                    
                nextDP = temp;
            }
        }

        return dp[0];
    }
}
