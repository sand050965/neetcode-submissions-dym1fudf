class Solution {
    List<Integer> combination = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        backtrack(nums, target, 0);

        return result;
    }

    private void backtrack(int[] nums, int target, int idx) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            int num = nums[i];
            if (target - num < 0) {
                return;
            }

            combination.add(num);
            backtrack(nums, target - num, i);
            combination.remove(combination.size() - 1);
        }
    }
}
