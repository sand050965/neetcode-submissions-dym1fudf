class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);

        return result;
    }

    private void dfs (int[] nums, int idx) {
        result.add(new ArrayList<>(curr));

        if (idx >= nums.length) return;

        for (int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);
            dfs(nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
