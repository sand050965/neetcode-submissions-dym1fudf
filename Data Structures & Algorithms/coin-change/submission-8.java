class Solution {
    Integer[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new Integer[amount + 1];
        int minCoins = dfs(coins, amount);

        return (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
    }

    private int dfs(int[] coins, int amount) {
        if (memo[amount] != null) {
            return memo[amount];
        }

        if (amount == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount < coin) {
                continue;
            }

            int result = dfs(coins, amount - coin);

            if (result != Integer.MAX_VALUE) {
                res = Math.min(res, 1 + result);
            }
        }

        return memo[amount] = res;
    }
}
