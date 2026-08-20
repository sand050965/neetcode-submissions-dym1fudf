class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses], result = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre: prerequisites) {
            int course = pre[0], preCourse = pre[1];
            indegree[course]++;
            adj.get(preCourse).add(course);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) dq.offer(i);
        }

        int finish = 0;
        int idx = 0;
        while(!dq.isEmpty()) {
            int course = dq.poll();
            finish++;
            result[idx++] = course;
            for (int nei: adj.get(course)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    dq.offer(nei);
                }
            }
        }

        return (finish == numCourses) ? result: new int[0];
    }
}
