class Solution {
    int n;
    Map<String, PriorityQueue<String>> adj = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        n = tickets.size();

        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            adj.computeIfAbsent(src, k -> new PriorityQueue<>()).offer(dst);
        }

        dfs("JFK");

        return result;
    }

    private void dfs(String node) {
        PriorityQueue<String> pq = adj.get(node);
        while (pq != null && !pq.isEmpty()) {
            String nei = pq.poll();
            dfs(nei);
        }

        result.addFirst(node);
    }
}
