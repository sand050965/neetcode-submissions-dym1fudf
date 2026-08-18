class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] prefixMinPrices = new int[n];
        int prefix = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int price = prices[i];
            prefixMinPrices[i] = prefix;
            prefix = Math.min(prefix, price);
        }

        for (int i = 0; i < n; i++) {
            result = Math.max(result, prices[i] - prefixMinPrices[i]);
        }

        return result;
    }
}
