class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int pre = prerequisite[0], course = prerequisite[1];

            adj.get(pre).add(course);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited.contains(i)) {
                continue;
            }

            if (!dfs(i)) {
                return false;
            }
        }

        return visited.size() == numCourses;
    }

    private boolean dfs(int course) {
        if (visited.contains(course)) {
            return true;
        }

        if (cycle.contains(course)) {
            return false;
        }

        cycle.add(course);

        for (int nei : adj.get(course)) {
            if (!dfs(nei)) {
                return false;
            }
        }

        cycle.remove(course);
        visited.add(course);

        return true;
    }
}
