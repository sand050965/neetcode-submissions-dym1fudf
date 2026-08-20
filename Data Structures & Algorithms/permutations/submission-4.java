class Solution {
    int n;
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    Set<Integer> visit = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        dfs(nums);

        return result;
    }

    private void dfs(int[] nums) {
        if (path.size() == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int num : nums) {
            if (visit.contains(num)) {
                continue;
            }

            path.add(num);
            visit.add(num);
            dfs(nums);
            path.remove(path.size() - 1);
            visit.remove(num);
        }
    }
}
