class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        for (int i = 0; i < k + 1; i++) {

            int[] copyCost = Arrays.copyOf(cost, n);

            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if (cost[from] == Integer.MAX_VALUE) {
                    continue;
                }

                if (cost[from] + price < copyCost[to]) {
                    copyCost[to] = cost[from] + price;
                }
            }

            cost = copyCost;
        }

        return (cost[dst] == Integer.MAX_VALUE) ? -1 : cost[dst];
    }
}
