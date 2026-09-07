class Solution {
    Map<String, PriorityQueue<String>> adj = new HashMap<>();
    Stack<String> stack = new Stack<>();
    LinkedList<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            adj.computeIfAbsent(src, k -> new PriorityQueue<>((a, b) -> a.compareTo(b))).add(dst);
        }

        // dfs("JFK");
        stack.push("JFK");
        while (!stack.isEmpty()) {
            String node = stack.peek();

            if (!adj.containsKey(node) || adj.get(node).isEmpty()) {
                result.addFirst(stack.pop());
            } else {
                stack.push(adj.get(node).poll());
            }
        }

        return result;
    }

    private void dfs(String node) {
        while (adj.containsKey(node) && !adj.get(node).isEmpty()) {
            dfs(adj.get(node).poll());
        }

        result.addFirst(node);
    }
}
