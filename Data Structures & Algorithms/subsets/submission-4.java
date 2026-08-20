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
        result.add(new ArrayList<>(path));

        for (int i = idx; i < n; i++) {
            int num = nums[i];
            
            path.add(num);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
