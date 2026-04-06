class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[amount] = 0;

        for (int i = amount - 1; i >= 0; i--) {
            for (int coin : coins) {
                if (coin > amount - i || dp[i + coin] == Integer.MAX_VALUE) {
                    continue;
                }

                dp[i] = Math.min(dp[i], 1 + dp[i + coin]);
            }
        }

        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
    }
}
