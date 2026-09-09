class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Map<Integer, List<int[]>> adj = new HashMap<>();
        Deque<int[]> dq = new ArrayDeque<>();
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int[] flight : flights) {
            int s = flight[0], d = flight[1], p = flight[2];
            adj.computeIfAbsent(s, key -> new ArrayList<>()).add(new int[] {d, p});
        }

        dq.offer(new int[] {src, 0});
        while (!dq.isEmpty() && k >= 0) {
            for (int i = dq.size(); i > 0; i--) {
                int[] curr = dq.poll();
                int node = curr[0], p = curr[1];

                for (int[] nei : adj.getOrDefault(node, new ArrayList<>())) {
                    int neiNode = nei[0], neiP = nei[1];
                    if (p + neiP < prices[neiNode]) {
                        prices[neiNode] = p + neiP;
                        dq.offer(new int[] {neiNode, p + neiP});
                    }
                }
            }

            k--;
        }

        return (prices[dst] == Integer.MAX_VALUE) ? -1 : prices[dst];
    }
}
