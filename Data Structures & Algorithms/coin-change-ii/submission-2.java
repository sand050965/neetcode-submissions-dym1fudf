class Solution {
    Integer[][] memo;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        memo = new Integer[n][amount + 1];

        return dfs(coins, n, 0, amount);
    }

    private int dfs(int[] coins, int n, int i, int amount) {
        if (i >= n)
            return 0;

        if (amount == 0)
            return 1;

        if (amount < 0)
            return 0;

        if (memo[i][amount] != null)
            return memo[i][amount];
        
        return memo[i][amount] = dfs(coins, n, i, amount - coins[i]) + dfs(coins, n, i + 1, amount);
    }
}
