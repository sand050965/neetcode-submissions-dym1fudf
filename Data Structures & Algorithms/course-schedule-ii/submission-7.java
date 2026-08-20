class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();
    Set<Integer> visit = new HashSet<>();
    List<Integer> res = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            adj.putIfAbsent(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int target = prerequisite[0];
            int pre = prerequisite[1];

            adj.get(target).add(pre);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visit.contains(i)) {
                continue;
            }

            if (!dfs(i)) {
                return new int[0];
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }

    private boolean dfs(int course) {
        if (visiting.contains(course)) {
            return false;
        }

        if (visit.contains(course)) {
            return true;
        }

        visiting.add(course);
        for (int nei : adj.get(course)) {
            if (!dfs(nei)) {
                return false;
            }
        }
        visiting.remove(course);
        visit.add(course);
        res.add(course);

        return true;
    }
}
