class Solution {
    List<Integer> path = new ArrayList<>();
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    Set<Integer> visit = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            adjMap.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int preCourse = pre[1];

            adjMap.get(course).add(preCourse);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = path.get(i);
        }

        return result;
    }

    private boolean dfs(int course) {
        if (cycle.contains(course)) {
            return false;
        }

        if (visit.contains(course)) {
            return true;
        }

        List<Integer> adj = adjMap.get(course);
        visit.add(course);
        cycle.add(course);
        for (int preCourse : adj) {
            if (!dfs(preCourse)) {
                return false;
            }
        }

        path.add(course);
        adjMap.put(course, new ArrayList<>());
        cycle.remove(course);

        return true;
    }
}
