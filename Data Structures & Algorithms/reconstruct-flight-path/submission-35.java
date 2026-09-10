class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        Stack<String> stack = new Stack<>();
        LinkedList result = new LinkedList<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            adj.computeIfAbsent(from, k -> new PriorityQueue<>((a, b) -> a.compareTo(b))).offer(to);
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
