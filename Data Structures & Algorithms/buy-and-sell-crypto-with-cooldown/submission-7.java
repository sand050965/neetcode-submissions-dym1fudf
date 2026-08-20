class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            int buy = dp[i + 1][1] - prices[i];
            int cooldown0 = dp[i + 1][0];
            dp[i][0] = Math.max(buy, cooldown0);

            int sell = (i + 2 <= n) ? dp[i + 2][0] + prices[i] : prices[i];
            int cooldown1 = dp[i + 1][1];
            dp[i][1] = Math.max(sell, cooldown1);
        }

        return dp[0][0];
    }
}
