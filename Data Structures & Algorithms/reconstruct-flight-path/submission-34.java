class Solution {
    Map<String, PriorityQueue<String>> adj = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            adj.computeIfAbsent(from, k -> new PriorityQueue<>((a, b) -> a.compareTo(b))).offer(to);
        }

        dfs("JFK");

        return result;
    }

    private void dfs(String node) {
        while (adj.containsKey(node) && !adj.get(node).isEmpty()) {
            dfs(adj.get(node).poll());
        }

        result.addFirst(node);
    }
}
