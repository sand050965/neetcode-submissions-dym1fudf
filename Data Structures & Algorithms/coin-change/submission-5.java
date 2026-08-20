class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int minCoins = dfs(coins, amount);

        return (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
    }

    private int dfs(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (memo.containsKey(amount)) return memo.get(amount);

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int diff = amount - coin;
            if (diff >= 0) {
                int result = dfs(coins, diff);

                if (result != Integer.MAX_VALUE)
                    res = Math.min(res, 1 + result);
            }
        }

        memo.put(amount, res);

        return res;
    }
}
