class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int n = prices.length, lowestPrice = prices[0], maxProfit = 0;
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - lowestPrice);
            lowestPrice = Math.min(lowestPrice, price);
        }

        return maxProfit;
    }
}
