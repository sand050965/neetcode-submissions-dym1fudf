class Solution {
    public int maxProfit(int[] prices) {
        int minBuyPrice = Integer.MAX_VALUE;
        int result = 0;

        for (int price : prices) {
            result = Math.max(result, price - minBuyPrice);
            minBuyPrice = Math.min(minBuyPrice, price);
        }

        return result;
    }
}
