class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> cycle = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    List<Integer> result = new LinkedList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0], pre = prerequisite[1];
            adj.computeIfAbsent(pre, k -> new ArrayList<>()).add(course);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return new int[0];
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int course) {
        if (cycle.contains(course)) {
            return false;
        }

        if (visited.contains(course)) {
            return true;
        }

        cycle.add(course);

        for (int nei : adj.getOrDefault(course, new ArrayList<>())) {
            if (!dfs(nei)) {
                return false;
            }
        }

        cycle.remove(course);
        visited.add(course);
        result.addFirst(course);

        return true;
    }
}
