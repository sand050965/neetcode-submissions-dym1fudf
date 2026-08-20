class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Queue<Integer> dq = new ArrayDeque<>();
        int[] indegree = new int[numCourses];
        List<Integer> path = new ArrayList<>();
        int[] result = new int[numCourses];
        int cnt = 0;

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int preCourse = pre[1];
            adjMap.computeIfAbsent(course, k -> new ArrayList<>()).add(preCourse);
            indegree[preCourse]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] != 0) {
                continue;
            }

            dq.offer(i);
        }

        while (!dq.isEmpty()) {
            int course = dq.poll();
            path.add(course);
            cnt++;

            for (int preCourse : adjMap.getOrDefault(course, new ArrayList<>())) {
                indegree[preCourse]--;

                if (indegree[preCourse] == 0) {
                    dq.offer(preCourse);
                }
            }
        }

        if (cnt != numCourses) {
            return new int[0];
        }

        Collections.reverse(path);
        for (int i = 0; i < numCourses; i++) {
            result[i] = path.get(i);
        }

        return result;
    }
}
