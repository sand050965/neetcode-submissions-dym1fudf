class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] pre: prerequisites) {
            int course = pre[0], preCourse = pre[1];
            map.computeIfAbsent(course, k -> new ArrayList<>()).add(preCourse);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }

        return true;
    }

    private boolean dfs(int course) {
        if (visited.contains(course)) return false;
        if (!map.containsKey(course)) return true;

        visited.add(course);

        for (int preCourse: map.get(course)) {
            if (!dfs(preCourse)) return false;
        }

        visited.remove(course);
        map.put(course, new ArrayList<>());

        return true;
    }
}
