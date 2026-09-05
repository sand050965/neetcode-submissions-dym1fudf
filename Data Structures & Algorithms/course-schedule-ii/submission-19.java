class Solution {
    int idx = 0, finished = 0;
    Map<Integer, List<Integer>> adj = new HashMap<>();
    int[] indegree;
    int[] result;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        indegree = new int[numCourses + 1];
        result = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0], pre = prerequisite[1];
            adj.computeIfAbsent(pre, k -> new ArrayList<>()).add(course);
            indegree[course]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] != 0) {
                continue;
            }

            dfs(i);
        }

        return (finished < numCourses) ? new int[0] : result;
    }

    private void dfs(int course) {
        result[idx++] = course;
        indegree[course]--;
        finished++;

        for (int nei : adj.getOrDefault(course, new ArrayList<>())) {
            indegree[nei]--;
            if (indegree[nei] == 0) {
                dfs(nei);
            }
        }
    }
}
