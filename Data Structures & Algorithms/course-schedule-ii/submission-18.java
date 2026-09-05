class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();
    int[] result;
    int idx;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        idx = numCourses - 1;
        result = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0], pre = prerequisite[1];
            adj.computeIfAbsent(pre, k -> new ArrayList<>()).add(course);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return new int[0];
            }
        }

        return result;
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
        result[idx--] = course;

        return true;
    }
}
