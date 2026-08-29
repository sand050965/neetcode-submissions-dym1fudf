class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);

        return result;
    }

    private void backtrack(int[] nums, int idx) {
        if (idx >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[idx]);
        backtrack(nums, idx + 1);
        
        subset.removeLast();
        backtrack(nums, idx + 1);
    }
}
