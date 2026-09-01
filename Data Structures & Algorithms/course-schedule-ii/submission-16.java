class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int idx = 0;
        int[] result = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> dq = new ArrayDeque<>();

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0], pre = prerequisite[1];
            adj.putIfAbsent(pre, new ArrayList<>());
            adj.get(pre).add(course);
            indegree[course]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                dq.offer(i);
            }
        }

        while (!dq.isEmpty()) {
            int node = dq.poll();
            result[idx++] = node;

            for (int nei : adj.getOrDefault(node, new ArrayList<>())) {
                indegree[nei]--;

                if (indegree[nei] == 0) {
                    dq.offer(nei);
                }
            }
        }

        return (idx != numCourses) ? new int[0] : result;
    }
}
