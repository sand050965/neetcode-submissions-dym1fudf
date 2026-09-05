class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0], pre = prerequisite[1];
            adj.computeIfAbsent(pre, k -> new ArrayList<>()).add(course);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course) {
        if (visited.contains(course)) {
            return true;
        }

        if (cycle.contains(course)) {
            return false;
        }

        cycle.add(course);

        for (int nei : adj.getOrDefault(course, new ArrayList<>())) {
            if (!dfs(nei)) {
                return false;
            }
        }

        cycle.remove(course);
        visited.add(course);

        return true;
    }
}
