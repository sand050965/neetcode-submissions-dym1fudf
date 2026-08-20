class Solution {
    Map<String, Queue<String>> adj = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        Stack<String> stack = new Stack<>();
        for (List<String> ticket: tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        stack.push("JFK");
        while (!stack.isEmpty()) {
            String curr = stack.peek();
            if (!adj.containsKey(curr) || adj.get(curr).isEmpty()) {
                result.add(stack.pop());
            } else {
                stack.push(adj.get(curr).poll());
            }
        }
        
        Collections.reverse(result);

        return result;
    }
}
