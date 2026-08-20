class Solution {
    int[] result;
    int idx = 0;
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visiting = new HashSet<>(), visited = new HashSet<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] pre: prerequisites) {
            int course = pre[0], preCourse = pre[1];
            map.get(course).add(preCourse);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return new int[0];
        }

        return result;
    }

    private boolean dfs(int course) {
        if (visiting.contains(course)) return false;
        if (visited.contains(course)) return true;

        visiting.add(course);
        for (int nei: map.get(course)) {
            if (!dfs(nei)) return false;
        }
        visiting.remove(course);
        result[idx++] = course;
        visited.add(course);

        return true;
    }
}
