class Solution {
    Map<String, PriorityQueue<String>> adj = new HashMap<>();
    List<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            adj.computeIfAbsent(from, k -> new PriorityQueue<>(
                (a, b) -> a.compareTo(b)
            )).add(to);
        }

        dfs("JFK");

        return result;
    }

    private void dfs(String node) {
        PriorityQueue<String> minHeap = adj.get(node);
        while (adj.containsKey(node) && !minHeap.isEmpty()) {
            String nei = minHeap.poll();;
            dfs(nei);
        }

        result.addFirst(node);
    }
}
