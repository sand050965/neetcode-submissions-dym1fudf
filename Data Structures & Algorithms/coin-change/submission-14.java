class Solution {
    Integer[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new Integer[amount + 1];
        int result = dfs(coins, amount);

        return (result != Integer.MAX_VALUE) ? result : -1;
    }

    private int dfs(int[] coins, int amount) {
        if (memo[amount] != null) {
            return memo[amount];
        }

        if (amount == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount < coin) {
                continue;
            }

            int res = dfs(coins, amount - coin);
            if (res != Integer.MAX_VALUE) {
                result = Math.min(result, 1 + res);
            }
        }

        return memo[amount] = result;
    }
}
