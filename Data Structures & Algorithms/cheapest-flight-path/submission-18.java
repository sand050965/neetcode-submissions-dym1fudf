class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int levels = 0;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        Deque<int[]> dq = new ArrayDeque<>();
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], price = flight[2];
            adj.computeIfAbsent(from, key -> new ArrayList<>()).add(new int[] {to, price});
        }

        dq.offer(new int[] {src, 0});
        while (!dq.isEmpty() && levels <= k) {
            for (int i = dq.size(); i > 0; i--) {
                int[] curr = dq.poll();
                int node = curr[0], price = curr[1];

                for (int[] nei : adj.getOrDefault(node, new ArrayList<>())) {
                    int neiNode = nei[0], neiPrice = nei[1];
                    int nextPrice = price + neiPrice;
                    if (nextPrice < prices[neiNode]) {
                        prices[neiNode] = nextPrice;
                        dq.offer(new int[] {neiNode, nextPrice});
                    }
                }
            }

            levels++;
        }

        return (prices[dst] == Integer.MAX_VALUE) ? -1 : prices[dst];
    }
}
