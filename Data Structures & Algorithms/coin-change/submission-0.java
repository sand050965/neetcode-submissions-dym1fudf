class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int amt = 1; amt <= amount; amt++) {
            for (int coin : coins) {
                int diff = amt - coin;
                if (diff >= 0 && dp[diff] != Integer.MAX_VALUE) {
                    dp[amt] = Math.min(dp[amt], 1 + dp[diff]);
                }
            }
        }

        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }
}
