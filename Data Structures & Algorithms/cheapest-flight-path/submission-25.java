class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            int[] tempPrices = Arrays.copyOf(prices, n);

            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], price = flight[2];
                if (prices[from] == Integer.MAX_VALUE) {
                    continue;
                }

                int nextPrice = prices[from] + price;

                if (nextPrice <= tempPrices[to]) {
                    tempPrices[to] = nextPrice;
                }
            }

            prices = tempPrices;
        }
        
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
