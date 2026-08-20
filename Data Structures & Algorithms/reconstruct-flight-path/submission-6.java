class Solution {
    Map<String, PriorityQueue<String>> adj = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            adj.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }

        dfs("JFK");
        Collections.reverse(result);

        return result;
    }

    private void dfs(String node) {
        Queue<String> minHeap = adj.get(node);

        while (minHeap != null && !minHeap.isEmpty()) {
            String nei = minHeap.poll();
            dfs(nei);
        }

        result.add(node);
    }
}
