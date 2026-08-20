class Solution {
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    Set<Integer> visitedSet = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }

        for (int i = 0; i < numCourses; i++) {
            adjMap.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            adjMap.get(pre[0]).add(pre[1]);
        }

        for (Map.Entry<Integer, List<Integer>> entry : adjMap.entrySet()) {
            int course = entry.getKey();

            if (!dfs(course)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course) {
        if (visitedSet.contains(course)) {
            return false;
        }

        if (adjMap.get(course).size() == 0) {
            return true;
        }

        visitedSet.add(course);
        for (int pre : adjMap.get(course)) {
            if (!dfs(pre)) {
                return false;
            }
        }

        visitedSet.remove(course);
        adjMap.put(course, new ArrayList<>());

        return true;
    }
}
