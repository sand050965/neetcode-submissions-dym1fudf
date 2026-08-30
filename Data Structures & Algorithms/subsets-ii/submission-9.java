class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);

        return result;
    }

    private void backtrack(int[] nums, int idx) {
        result.add(new ArrayList<>(path));

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }
}
