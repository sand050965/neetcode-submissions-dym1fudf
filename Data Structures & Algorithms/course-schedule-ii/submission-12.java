class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    List<Integer> result = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {        
        for (int i = 0; i < numCourses; i++) {
            adj.putIfAbsent(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int pre = prerequisite[0];
            int target = prerequisite[1];

            adj.get(pre).add(target);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return new int[0];
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int course) {
        if (visiting.contains(course)) {
            return false;
        }

        if (visited.contains(course)) {
            return true;
        }

        visiting.add(course);
        for (int nei : adj.get(course)) {
            if (!dfs(nei)) {
                return false;
            }
        }
        visiting.remove(course);
        visited.add(course);
        result.add(course);

        return true;
    }
}
