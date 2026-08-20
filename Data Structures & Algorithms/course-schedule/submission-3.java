class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre: prerequisites) {
            int course = pre[0], preCourse = pre[1];
            indegree[preCourse]++;
            adj.get(course).add(preCourse);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                dq.offer(i);
        }

        int finish = 0;
        while(!dq.isEmpty()) {
            int course = dq.poll();
            finish++;
            for (int nei: adj.get(course)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    dq.offer(nei);
                }
            }
        }

        return finish == numCourses;
    }
}
