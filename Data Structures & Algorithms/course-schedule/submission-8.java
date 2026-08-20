class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int cnt = 0;
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Queue<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            adjMap.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int preCourse = pre[1];

            indegree[preCourse]++;
            adjMap.get(course).add(preCourse);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] != 0) {
                continue;
            }

            dq.offer(i);
        }

        while (!dq.isEmpty()) {
            int course = dq.poll();
            cnt++;

            for (int preCourse : adjMap.get(course)) {
                indegree[preCourse]--;

                if (indegree[preCourse] == 0) {
                    dq.offer(preCourse);
                }
            }
        }

        return cnt == numCourses;
    }
}
