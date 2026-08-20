class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            int[] copy = Arrays.copyOf(prices, n);

            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if (prices[from] == Integer.MAX_VALUE) {
                    continue;
                }

                if (prices[from] + price < copy[to]) {
                    copy[to] = prices[from] + price;
                }
            }

            prices = copy;
        }

        return (prices[dst] != Integer.MAX_VALUE) ? prices[dst] : -1;
    }
}
