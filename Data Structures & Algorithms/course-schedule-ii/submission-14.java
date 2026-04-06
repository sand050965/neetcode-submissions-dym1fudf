class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];

            adj.get(preCourse).add(course);
            indegree[course]++;
        }

        Queue<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                dq.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!dq.isEmpty()) {
            int course = dq.poll();
            result.add(course);

            for (int nei : adj.get(course)) {
                indegree[nei]--;

                if (indegree[nei] == 0) {
                    dq.offer(nei);
                }
            }
        }

        return result.size() != numCourses ? new int[0] : result.stream().mapToInt(Integer::intValue).toArray();
    }
}
