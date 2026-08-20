class Solution {
    int n;
    Map<String, List<String>> adj = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        n = tickets.size();
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }

        result.add("JFK");
        return dfs(tickets, "JFK") ? result : new ArrayList<>();
    }

    private boolean dfs(List<List<String>> tickets, String node) {
        if (result.size() == tickets.size() + 1) {
            return true;
        }

        if (!adj.containsKey(node) || adj.get(node).isEmpty()) {
            return false;
        }

        List<String> copy = adj.get(node);
        for (int i = 0; i < copy.size(); i++) {
            String nei = copy.get(i);
            result.add(nei);
            adj.get(node).remove(i);
            
            if(dfs(tickets, nei)) {
                return true;
            }

            result.remove(result.size() - 1);
            adj.get(node).add(i, nei);
        }

        return false;
    }
}
