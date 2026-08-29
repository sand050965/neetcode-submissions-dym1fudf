class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);

        return result;
    }

    private void backtrack(int[] nums, int idx) {
        if (idx >= nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[idx]);
        backtrack(nums, idx + 1);
        path.removeLast();
        while (idx + 1 < nums.length && nums[idx] == nums[idx + 1]) {
            idx++;
        }
        backtrack(nums, idx + 1);
    }
}
