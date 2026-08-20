class Solution {
    Map<String, Integer> memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new HashMap<>();

        return dfs(prices, n, 0, true);
    }

    private int dfs(int[] prices, int n, int i, boolean isBuying) {
        if (i >= n)
            return 0;
        
        String key = i + "-" + isBuying;
        if (memo.containsKey(key))
            return memo.get(key);

        int cooldown = dfs(prices, n, i + 1, isBuying);
        if (isBuying) {
            int buy = dfs(prices, n, i + 1, false) - prices[i];
            memo.put(key, Math.max(buy, cooldown));
        } else {
            int sell = dfs(prices, n, i + 2, true) + prices[i];
            memo.put(key, Math.max(sell, cooldown));
        }

        return memo.get(key);
    }
}
