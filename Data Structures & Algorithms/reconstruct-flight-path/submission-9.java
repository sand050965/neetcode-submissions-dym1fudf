class Solution {
    Map<String, Queue<String>> adj = new HashMap<>();
    List<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            adj.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }

        dfs("JFK");

        return result;
    }

    private void dfs(String node) {
        Queue<String> minHeap = adj.get(node);
        while (minHeap != null && !minHeap.isEmpty()) {
            String nei = minHeap.poll();
            dfs(nei);
        }

        result.addFirst(node);
    }
}
