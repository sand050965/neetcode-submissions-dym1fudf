class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][amount] = 0;
        }

        for (int i = n - 1; i >= 0; i--) {
            int coin = coins[i];

            for (int j = amount - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];

                if (coin <= amount - j && dp[i][j + coin] < Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j + coin]);
                }
            }
        }

        return dp[0][0] == Integer.MAX_VALUE ? -1 : dp[0][0];
    }
}
