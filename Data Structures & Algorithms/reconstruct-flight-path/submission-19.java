class Solution {
    Map<String, PriorityQueue<String>> adj = new HashMap<>();
    List<String> result = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            adj.computeIfAbsent(src, k -> new PriorityQueue<>()).offer(dst);
        }

        dfs("JFK");

        return result;
    }

    private void dfs(String node) {
        PriorityQueue<String> adjList = adj.get(node);

        while (adjList != null && !adjList.isEmpty()) {
            String nei = adjList.poll();
            dfs(nei);
        }

        result.addFirst(node);
    }
}
