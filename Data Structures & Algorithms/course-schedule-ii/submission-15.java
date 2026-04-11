class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int targetCourse = prerequisite[0];
            int preCourse = prerequisite[1];

            adj.get(preCourse).add(targetCourse);
            indegree[targetCourse]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                dq.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int idx = 0;
        while (!dq.isEmpty()) {
            int course = dq.poll();
            result[idx++] = course;

            for (int nei : adj.get(course)) {
                indegree[nei]--;

                if (indegree[nei] == 0) {
                    dq.offer(nei);
                }
            }
        }

        return (idx == numCourses) ? result : new int[0];
    }
}
