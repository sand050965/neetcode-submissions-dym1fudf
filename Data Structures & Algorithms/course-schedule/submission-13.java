class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.putIfAbsent(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int preCourse = prerequisite[0];
            int course = prerequisite[1];

            adj.get(preCourse).add(course);
            indegree[course]++;
        }

        Queue<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                dq.offer(i);
            }
        }

        int result = 0;
        while (!dq.isEmpty()) {
            int course = dq.poll();
            result++;

            for (int nei : adj.get(course)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    dq.offer(nei);
                }
            }
        }

        return result == numCourses;
    }
}
