class Solution {
    Map<String, List<String>> adj = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        for (List<String> ticket: tickets) {
            adj.computeIfAbsent(ticket.get(0), key -> new ArrayList<>()).add(ticket.get(1));
        }

        result.add("JFK");
        if (dfs(tickets, "JFK")) return result;

        return new ArrayList<>();
    }

    private boolean dfs(List<List<String>> tickets, String node) {
        if (result.size() == tickets.size() + 1) return true;
        if (!adj.containsKey(node)) return false;

        List<String> temp = new ArrayList<>(adj.get(node));
        for (int i = 0; i < temp.size(); i++) {
            String nei = temp.get(i);
            adj.get(node).remove(i);
            result.add(nei);
            if (dfs(tickets, nei)) return true;
            adj.get(node).add(i, nei);
            result.remove(result.size() - 1);
        }

        return false;
    }
}
