class Solution {
    List<Integer> subset = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        recurse(nums, 0);

        return result;
    }

    private void recurse(int[] nums, int idx) {
        if (idx >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[idx]);
        recurse(nums, idx + 1);
        subset.removeLast();

        recurse(nums, idx + 1);
    }
}
