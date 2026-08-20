class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> adj = new HashMap<>();
        Stack<String> stack = new Stack<>();
        List<String> result = new LinkedList<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            adj.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
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
