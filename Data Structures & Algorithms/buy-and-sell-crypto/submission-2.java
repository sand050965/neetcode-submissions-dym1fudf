class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int n = prices.length, result = 0, l = 0, r = l + 1;

        while (r < n) {
            if (prices[l] < prices[r]) {
                result = Math.max(result, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;
        }

        return result;
    }
}
