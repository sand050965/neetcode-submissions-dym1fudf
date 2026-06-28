class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int result = 0;

        for (int price : prices) {
            result = Math.max(result, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }

        return result;
    }
}
