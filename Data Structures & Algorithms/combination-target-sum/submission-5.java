class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        backtrack(nums, target, 0);

        return result;
    }

    private void backtrack(int[] nums, int target, int idx) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            int num = nums[i];
            path.add(num);
            backtrack(nums, target - num, i);
            path.removeLast();
        }
    }
}
