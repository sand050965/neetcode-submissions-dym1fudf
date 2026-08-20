class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, target, 0, 0);

        return result;
    }

    private void backtrack(int[] nums, int target, int idx, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (idx >= nums.length || sum > target) return;

        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, target, i, sum + nums[i]);
            path.remove(path.size() - 1);
        }
    }
}
