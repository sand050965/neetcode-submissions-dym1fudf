class Solution {
    int[] cache;
    public int coinChange(int[] coins, int amount) {
        cache = new int[amount + 1];
        Arrays.fill(cache, -2);
        return dfs(coins, amount);
    }

    private int dfs(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (cache[amount] != -2) return cache[amount];

        int min = Integer.MAX_VALUE;
        for (int coin: coins) {
            if (amount - coin >= 0) {
                int result = dfs(coins, amount - coin);
                if (result >= 0)
                    min = Math.min(min, 1 + result);
            }
        }
        
        return cache[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
    }
}
