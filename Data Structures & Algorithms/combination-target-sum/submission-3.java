class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, target, 0);

        return result;
    }

    private void backtrack(int[] nums, int target, int idx) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (target < 0 || idx >= nums.length) {
            return;
        }

        int num = nums[idx];
        path.add(num);
        backtrack(nums, target - num, idx);
        path.removeLast();
        backtrack(nums, target, idx + 1);
    }
}
