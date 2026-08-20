class Solution {
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    Set<Integer> visit = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            adjMap.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisiteCourse = pre[1];
            adjMap.get(course).add(prerequisiteCourse);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course) {
        if (visit.contains(course)) {
            return false;
        }
        
        List<Integer> prerequisites = adjMap.get(course);
        if (prerequisites.size() == 0) {
            return true;
        }

        visit.add(course);
        for (int preCourse : prerequisites) {
            if(!dfs(preCourse)) {
                return false;
            }
        }
        visit.remove(course);
        // adjMap.put(course, new ArrayList<>());

        return true;
    }
}
