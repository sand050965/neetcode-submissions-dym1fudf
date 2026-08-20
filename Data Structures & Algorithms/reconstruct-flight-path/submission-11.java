class Solution {
    Map<String, PriorityQueue<String>> adj = new HashMap<>();
    List<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            adj.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }

        dfs("JFK");

        return result;
    }

    private void dfs(String node) {
        while (adj.containsKey(node) && !adj.get(node).isEmpty()) {
            String nei = adj.get(node).poll();
            dfs(nei);
        }

        result.addFirst(node);
    }
}
