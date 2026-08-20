class Solution {
    Integer[][] memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new Integer[n][2];


        return dfs(prices, n, 0, true);
    }

    private int dfs(int[] prices, int n, int i, boolean canBuy) {        
        int canBuyVar = canBuy ? 1 : 0;
        if (i >= n)
            return 0;

        if (memo[i][canBuyVar] != null)
            return memo[i][canBuyVar];

        if (canBuy) {
            int buy = dfs(prices, n, i + 1, false) - prices[i];
            int cooldown = dfs(prices, n, i + 1, canBuy);
            
            return memo[i][canBuyVar] = Math.max(buy, cooldown);
        } else {
            int sell = dfs(prices, n, i + 2, true) + prices[i];
            int cooldown = dfs(prices, n, i + 1, canBuy);

            return memo[i][canBuyVar] = Math.max(sell, cooldown);
        }
    }
}
