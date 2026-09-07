class Solution {
    Map<String, PriorityQueue<String>> adj = new HashMap<>();
    Deque<String> result = new LinkedList<>();
    Queue<String> dq = new ArrayDeque<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            adj.computeIfAbsent(src, k -> new PriorityQueue<>((a, b) -> a.compareTo(b))).add(dst);
        }

        dfs("JFK");

        return new LinkedList<>(result);
    }

    private void dfs(String node) {
        while (adj.containsKey(node) && !adj.get(node).isEmpty()) {
            String nei = adj.get(node).poll();
            dfs(nei);
        }

        result.addFirst(node);
    }
}
