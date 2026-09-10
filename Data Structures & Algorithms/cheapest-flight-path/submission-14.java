class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int stops = 0;
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        while (stops <= k) {
            int[] pricesCopy = Arrays.copyOf(prices, n);
            
            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], price = flight[2];

                if (prices[from] == Integer.MAX_VALUE) {
                    continue;
                }

                if (prices[from] + price < pricesCopy[to]) {
                    pricesCopy[to] = prices[from] + price;
                }
            }

            prices = pricesCopy;
            stops++;
        }

        return (prices[dst] == Integer.MAX_VALUE) ? -1 : prices[dst];
    }
}
