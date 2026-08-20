class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[amount + 1][n + 1];
        Arrays.fill(dp[0], 1);

        for (int i = 0; i <= amount; i++) {
            for (int j = n - 1; j >= 0; j--) {
                int coin = coins[j];
                dp[i][j] = dp[i][j + 1];
                
                if (i >= coin) {
                    dp[i][j] += dp[i - coin][j];
                }
            }
        }

        return dp[amount][0];
    }
}
