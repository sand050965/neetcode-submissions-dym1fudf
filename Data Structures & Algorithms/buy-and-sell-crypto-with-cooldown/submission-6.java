class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp1Stock = 0, dp1NoStock = 0, dp2NoStock = 0;


        for (int i = n - 1; i >= 0; i--) {
            int buy = dp1Stock - prices[i];
            int cooldown0 = dp1NoStock;
            int noStock = Math.max(buy, cooldown0);

            int sell = dp2NoStock + prices[i];
            int cooldown1 = dp1Stock;
            int stock = Math.max(sell, cooldown1);

            dp2NoStock = dp1NoStock;
            dp1NoStock = noStock;
            dp1Stock = stock;
        }

        return dp1NoStock;
    }
}
