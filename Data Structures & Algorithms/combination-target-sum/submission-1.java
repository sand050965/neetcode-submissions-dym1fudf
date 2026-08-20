class Solution {
    List<Integer> combination = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, target, 0);

        return result;
    }

    private void backtrack(int[] nums, int target, int idx) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if (target < 0 || idx >= nums.length) {
            return;
        }

        int num = nums[idx];
        combination.add(num);
        backtrack(nums, target - num, idx);
        combination.remove(combination.size() - 1);

        backtrack(nums, target, idx + 1);
    }
}
