class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        
        for (int i = 0; i < k + 1; i++) {
            int[] tmpPrices = Arrays.copyOf(prices, n);

            for (int[] flight: flights) {
                int s = flight[0], d = flight[1], p = flight[2];
                if (prices[s] == Integer.MAX_VALUE)
                    continue;
                if (prices[s] + p < tmpPrices[d])
                    tmpPrices[d] = prices[s] + p;
            }

            prices = tmpPrices;
        }

        return (prices[dst] != Integer.MAX_VALUE) ? prices[dst] : -1;
    }
}
