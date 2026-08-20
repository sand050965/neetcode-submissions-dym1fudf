class Solution {
    Map<String, PriorityQueue<String>> adj = new HashMap<>();
    List<String> result = new ArrayList<>();
    Stack<String> stack = new Stack<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }

        stack.push("JFK");
        while (!stack.isEmpty()) {
            String node = stack.peek();

            if (!adj.containsKey(node) || adj.get(node).isEmpty()) {
                result.addFirst(stack.pop());
                continue;
            }

            stack.push(adj.get(node).poll());
        }

        return result;
    }
}
