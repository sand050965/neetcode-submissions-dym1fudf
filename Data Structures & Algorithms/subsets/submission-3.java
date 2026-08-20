class Solution {
    int n;
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        dfs(nums, 0);

        return result;
    }

    private void dfs(int[] nums, int idx) {
        if (idx >= n) {
            result.add(new ArrayList<>(path));
            return;
        }

        int num = nums[idx];
        path.add(num);
        dfs(nums, idx + 1);
        path.remove(path.size() - 1);

        dfs(nums, idx + 1);
    }
}
