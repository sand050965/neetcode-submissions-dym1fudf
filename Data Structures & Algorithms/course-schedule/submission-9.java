class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> dq = new ArrayDeque<>();
        Set<Integer> visit = new HashSet<>();

        for (int[] prerequisite : prerequisites) {
            int target = prerequisite[0];
            int pre = prerequisite[1];

            adj.computeIfAbsent(pre, k -> new ArrayList<>()).add(target);
            indegree[target]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                dq.offer(i);
            }
        }

        while (!dq.isEmpty()) {
            int course = dq.poll();
            visit.add(course);

            for (int nei : adj.getOrDefault(course, new ArrayList<>())) {
                indegree[nei]--;

                if (indegree[nei] == 0) {
                    dq.offer(nei);
                }
            }
        }

        return visit.size() == numCourses;
    }
}
