class Solution {
    List<Integer> path = new ArrayList<>();
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    Set<Integer> visit = new HashSet<>();
    Set<Integer> take = new HashSet<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int preCourse = pre[1];

            adjMap.computeIfAbsent(course, k -> new ArrayList<>()).add(preCourse);
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
        if (visit.contains(course)) {
            return false;
        }

        if (take.contains(course)) {
            return true;
        }

        visit.add(course);

        for (int preCourse : adjMap.getOrDefault(course, new ArrayList<>())) {
            if (!dfs(preCourse)) {
                return false;
            }
        }

        visit.remove(course);
        path.add(course);
        take.add(course);

        return true;
    }
}
