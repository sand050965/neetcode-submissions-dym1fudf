class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] dp = new int[n + 1];
        int[] nextDP = new int[n + 1];

        for (int i = 0; i <= n; i++)
            dp[i] = n - i;
        

        for (int i = m - 1; i >= 0; i--) {
            nextDP[n] = m - i; 
            
            for (int j = n - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j))
                    nextDP[j] = dp[j + 1];
                else
                    nextDP[j] = 1 + Math.min(
                        dp[j],
                        Math.min(
                            nextDP[j + 1],
                            dp[j + 1]
                        )
                    );
            }
            dp = nextDP.clone();
        }

        return dp[0];
    }
}
