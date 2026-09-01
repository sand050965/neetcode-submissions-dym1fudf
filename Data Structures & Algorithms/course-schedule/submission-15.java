class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int result = 0;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Queue<Integer> dq = new ArrayDeque<>();
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int target = prerequisite[0], prereq = prerequisite[1];
            adj.putIfAbsent(prereq, new ArrayList<>());
            adj.get(prereq).add(target);
            indegree[target]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                dq.offer(i);
            }
        }

        while (!dq.isEmpty()) {
            int course = dq.poll();
            result++;

            for (int nei : adj.getOrDefault(course, new ArrayList<>())) {
                indegree[nei]--;

                if (indegree[nei] == 0) {
                    dq.offer(nei);
                }
            }
        }

        return result == numCourses;
    }
}
