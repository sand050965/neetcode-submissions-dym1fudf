class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> dq = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.putIfAbsent(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int pre = prerequisite[0];
            int target = prerequisite[1];

            adj.get(target).add(pre);
            indegree[pre]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                dq.offer(i);
            }
        }

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

        return (result.size() != numCourses) ? 
                new int[0] : 
                result.stream().mapToInt(Integer::intValue).toArray();
    }
}
