class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            adj.putIfAbsent(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int target = prerequisite[0];
            int pre = prerequisite[1];

            adj.get(target).add(pre);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited.contains(i)) {
                continue;
            }

            if (!dfs(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course) {
        if (visiting.contains(course)) {
            return false;
        }

        visiting.add(course);
        for (int nei : adj.get(course)) {
            if(!dfs(nei)) {
                return false;
            }
        }
        visiting.remove(course);
        visited.add(course);

        return true;
    }
}
